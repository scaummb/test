package annotation.database.testcase;

import annotation.database.annotation.Constraints;
import annotation.database.annotation.DBTable;
import annotation.database.annotation.SQLInteger;
import annotation.database.annotation.SQLString;
import annotation.database.bean.Member;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * <p>注解处理器</p>
 * @author momoubin
 * @date 2020/5/16
 */
public class TableCreator {
    public static void main(String[] args) throws ClassNotFoundException {

        String[] test = new String[]{Member.class.getName()};

        for (String className : test){
            Class<?> cl = Class.forName(className);
            DBTable dbTable = cl.getAnnotation(DBTable.class);
            if (dbTable == null){
                System.out.println("Not found annotation in class " + className);
                continue;
            }
            // 表名
            String tableName = dbTable.name();
            if (tableName.length() < 1){
                tableName = cl.getName().toUpperCase();
            }
            // 表列字段集合
            ArrayList<String> columnDefs = new ArrayList<>();
            // 遍历类的所有属性
            for (Field field : cl.getDeclaredFields()){
                String columnName = null;
                // 每个成员变量都可能有注解
                Annotation[] anns = field.getDeclaredAnnotations();

                if (anns.length < 1){
                    continue;
                }

                // 假如变量注解为 SQLInteger
                if (anns[0] instanceof SQLInteger){
                    SQLInteger sInt = (SQLInteger) anns[0];
                    if (sInt.name().length() < 1){
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sInt.name();
                    }
                    columnDefs.add(columnName + " Int " + getConstraints(sInt.constraints()));
                }

                // 假如变量注解为 SQLString
                if (anns[0] instanceof SQLString){
                    SQLString sString = (SQLString) anns[0];
                    if (sString.name().length() < 1){
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sString.name();
                    }
                    columnDefs.add(columnName + " VARCHAR " + getConstraints(sString.constraints()));
                }


            }
            StringBuilder stringBuilder = new StringBuilder("Create OpcLogData " + tableName + "(");
            for (String column : columnDefs){
                stringBuilder.append("\n " + column + ", ");
            }
            String tableCreate = stringBuilder.substring(0, stringBuilder.length() - 1) + ")";
            System.out.println(tableCreate);

        }

    }
    private static String getConstraints(Constraints con){
        String constraints = "";
        if (!con.allowNull()){
            constraints = " NOT NULL";
        }
        if (!con.primaryKey()){
            constraints = " PRIMARY KEY";
        }
        if (!con.unique()){
            constraints = " UNIQUE";
        }
        return constraints;
    }
}

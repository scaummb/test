package Utils;

/**
 * Date: 2019/5/31 17 :09
 *
 * @author moubin.mo
 */

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.io.Serializable;

public class Tuple<A, B> implements Serializable {
    private static final long serialVersionUID = -4131628856359830761L;
    private A first;
    private B second;

    public Tuple(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public A first() {
        return this.first;
    }

    public B second() {
        return this.second;
    }

    @Override
    public int hashCode() {
        int hashCode = 0;
        if (this.first != null) {
            hashCode = this.first.hashCode();
        }

        if (this.second != null) {
            hashCode += hashCode << 4;
            hashCode ^= this.second.hashCode();
        }

        return hashCode;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        } else if (!(other instanceof Tuple)) {
            return false;
        } else if (this == other) {
            return true;
        } else {
            if (this.first != null) {
                if (!this.first.equals(((Tuple)other).first())) {
                    return false;
                }
            } else if (((Tuple)other).first() != null) {
                return false;
            }

            return this.second == null && ((Tuple)other).second() == null || this.second != null && this.second.equals(((Tuple)other).second());
        }
    }
}

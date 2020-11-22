package effectivejava.no19;

import static effectivejava.no19.PhysicalConstants.AVOGADROS_NUMBER;
/**jdk1.5后引入静态导入机制*/
public class Test {
	double atoms(double mols){
		return AVOGADROS_NUMBER * mols;
	}
}

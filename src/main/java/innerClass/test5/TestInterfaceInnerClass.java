package innerClass.test5;

/**
 * @author moubin.mo
 * @date: 2021/2/1 11:50
 */

public class TestInterfaceInnerClass {
	private class PContents implements Conents {
		private int i = 11;

		@Override
		public int value() {
			return i;
		}
	}

	protected class PDestination implements Destination {
		private String label;

		private PDestination(String whereTo) {
			label = whereTo;
		}

		@Override
		public String readLabel() {
			return label;
		}
	}

	public Destination destination(String s) {
		return new PDestination(s);
	}

	public Conents contents() {
		return new PContents();
	}
}

package polymorphic;

/**
 * @author momoubin
 * @date 2020/5/10
 */
public class Music {
	/**
	 * <p>接口入参是基类</p>
	 */
	public static void tune(Instrument i) {
		i.play(Note.B_FLAT);
	}

	public static void main(String[] args) {
		Wind wind = new Wind();
		tune(wind);
	}
}

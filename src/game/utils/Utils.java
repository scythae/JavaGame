package game.utils;

public class Utils {
	static public void Debug(String s) {
		System.out.println(s);
	}

	static public void Debug(Object o) {
		System.out.println(o.toString());
	}

	static public void DebugClear() {
		System.out.flush();
	}
}

package version_control;

import java.io.Serializable;
import java.security.InvalidParameterException;

/**
 * @author moubin.mo
 * @date: 2019/10/19 20:46
 */

public class Version implements Serializable {
	private static final long serialVersionUID = -8094319325751987537L;
	private static final int MAX_VERSION_BITS = 10;
	private static final int MAX_VERSION_VALUE = 1024;
	private static final int MAX_VERSION_VALUE_MASK = 1023;
	private static final int MAJOR = 1;
	private static final int MINOR = 0;
	private static final int REVISION = 0;
	private int major = 1;
	private int minor = 0;
	private int revision = 0;
	private String tag;

	public Version() {
	}

	public Version(int major, int minor, int revision) {
		this.major = major;
		this.minor = minor;
		this.revision = revision;
	}

	public Version(int major, int minor, int revision, String tag) {
		this.major = major;
		this.minor = minor;
		this.revision = revision;
		this.tag = tag;
	}

	public int getMajor() {
		return this.major;
	}

	public void setMajor(int major) {
		if (major >= 1024) {
			throw new InvalidParameterException();
		} else {
			this.major = major;
		}
	}

	public int getMinor() {
		return this.minor;
	}

	public void setMinor(int minor) {
		if (minor >= 1024) {
			throw new InvalidParameterException();
		} else {
			this.minor = minor;
		}
	}

	public int getRevision() {
		return this.revision;
	}

	public void setRevision(int revision) {
		if (revision >= 1024) {
			throw new InvalidParameterException();
		} else {
			this.revision = revision;
		}
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		if (tag == null || !tag.contains("-") && !tag.contains(":")) {
			this.tag = tag;
		} else {
			throw new InvalidParameterException("Version tag contains invalid characeters");
		}
	}

	public long getEncodedValue() {
		return encodeValue(this.major, this.minor, this.revision);
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(String.valueOf(this.major)).append(".");
		sb.append(String.valueOf(this.minor)).append(".");
		sb.append(String.valueOf(this.revision));
		if (this.tag != null && !this.tag.isEmpty()) {
			sb.append("-").append(this.tag);
		}

		return sb.toString();
	}

	public static Version MAX() {
		Version maxVersion = new Version();
		maxVersion.setMajor(1023);
		maxVersion.setMinor(1023);
		maxVersion.setRevision(1023);
		return maxVersion;
	}

	public static long encodeValue(int major, int minor, int revision) {
		return (long)(major << 20 | minor << 10 | revision);
	}

	public static Version fromEncodedValue(long encodedValue) {
		Version version = new Version();
		version.setMajor((int)(encodedValue >> 20 & 1023L));
		version.setMinor((int)(encodedValue >> 10 & 1023L));
		version.setRevision((int)(encodedValue & 1023L));
		return version;
	}

	public static Version fromVersionString(String versionString) {
		assert versionString != null;

		String[] tokens = versionString.split("\\.|-");
		if (tokens.length != 3 && tokens.length != 4) {
			throw new InvalidParameterException("Invalid version string: " + versionString);
		} else {
			Version ver = new Version();
			ver.setMajor(Integer.parseInt(tokens[0]));
			ver.setMinor(Integer.parseInt(tokens[1]));
			ver.setRevision(Integer.parseInt(tokens[2]));
			if (tokens.length == 4) {
				ver.setTag(tokens[3]);
			}

			return ver;
		}
	}
}

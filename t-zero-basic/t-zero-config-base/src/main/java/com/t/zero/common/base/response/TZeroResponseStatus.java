package com.t.zero.common.base.response;



public enum TZeroResponseStatus {
	OK(200, Series.SUCCESSFUL, "OK"),
	ERROR(500, Series.CLIENT_ERROR, "CLIENT_ERROR");
//	LOGINERROR(401,Series.CLIENT_ERROR,"账号或密码错误");

	private final int value;

	private final Series series;

	private final String reasonPhrase;

	TZeroResponseStatus(int value, Series series, String reasonPhrase) {
		this.value = value;
		this.series = series;
		this.reasonPhrase = reasonPhrase;
	}

	/**
	 * Return the integer value of this status code.
	 */
	public int value() {
		return this.value;
	}

	/**
	 * Return the HTTP status series of this status code.
	 * 

	 */
	public Series series() {
		return this.series;
	}

	/**
	 * Return the reason phrase of this status code.
	 */
	public String getReasonPhrase() {
		return this.reasonPhrase;
	}


	/**
	 * Enumeration of HTTP status series.
	 * <p>
	 *
	 */
	public enum Series {

		INFORMATIONAL(1), SUCCESSFUL(2), REDIRECTION(3), CLIENT_ERROR(4), SERVER_ERROR(5);

		private final int value;

		Series(int value) {
			this.value = value;
		}

		/**
		 * Return the integer value of this status series. Ranges from 1 to 5.
		 */
		public int value() {
			return this.value;
		}

		/**
		 * Return the {@code Series} enum constant for the supplied status code.
		 * 
		 * @param statusCode the HTTP status code (potentially non-standard)
		 * @return the {@code Series} enum constant for the supplied status code
		 * @throws IllegalArgumentException if this enum has no corresponding constant
		 */
		public static Series valueOf(int statusCode) {
			Series series = resolve(statusCode);
			if (series == null) {
				throw new IllegalArgumentException("No matching constant for [" + statusCode + "]");
			}
			return series;
		}

		/**
		 * Resolve the given status code to an {@code HttpStatus.Series}, if possible.
		 * 
		 * @param statusCode the HTTP status code (potentially non-standard)
		 * @return the corresponding {@code Series}, or {@code null} if not found
		 * @since 5.1.3
		 */
		public static Series resolve(int statusCode) {
			int seriesCode = statusCode / 100;
			for (Series series : values()) {
				if (series.value == seriesCode) {
					return series;
				}
			}
			return null;
		}
	}

}

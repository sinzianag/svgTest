package me.sinziana.svgtest.svg;

/**
 * Runtime exception thrown when there is a problem parsing an SVG.
 * 
 * @author Larva Labs, LLC
 */
public class SVGParseException extends RuntimeException {

	public SVGParseException(Throwable throwable) {
		super(throwable);
	}
}

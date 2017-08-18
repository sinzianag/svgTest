package me.sinziana.svgtest.svg;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PictureDrawable;
import android.util.Log;

/**
 * Based on work by nimingtao:
 * https://code.google.com/p/adet/source/browse/trunk/adet/src/cn/mobileww/adet/graphics/SvgDrawable.java
 * 
 * @since 19 Aug 2013
 * @author nimingtao, mstevens83
 */
public class SVGDrawable extends PictureDrawable {

	private final String TAG = "SVGDrawable";

	public SVGDrawable(SVG svg) {
		super(svg.getPicture());
	}

	@Override
	protected void onBoundsChange(Rect bounds) {
		super.onBoundsChange(bounds);
	}

	@Override
	public void draw(Canvas canvas) {
		if (getPicture() != null) {
			Rect bounds = getBounds();
			canvas.save();
			// draw picture to fit bounds!
			canvas.drawPicture(getPicture(), bounds);
			canvas.restore();
		}
	}



}
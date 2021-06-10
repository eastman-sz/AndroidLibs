package com.common.base;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;
/**
 * 自定义带字体的ditText。 
 * @author E
 */
public class CustomFontDigitEditText extends EditText {

	public CustomFontDigitEditText(Context context) {
		super(context);

		init();
	}

	public CustomFontDigitEditText(Context context, AttributeSet attrs) {
		super(context, attrs);

		init();
	}

	public CustomFontDigitEditText(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		
		init();
	}
	
	private void init() {
		if (!isInEditMode()) {
//			final Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), getContext().getString(R.string.font_fzlting));
			final Typeface typeface = TypefaceHelper.getInstance().getDigitTypeface(getContext());
			setTypeface(typeface);
		}
	}

}

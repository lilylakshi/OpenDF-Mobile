package score.gsoc.opendf.widgets;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by lilan on 3/22/16.
 */
public class CustomLightEditText extends EditText {
    public CustomLightEditText(Context context) {
        super(context);
        setTypeFace();
    }

    public CustomLightEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeFace();
    }

    public CustomLightEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypeFace();
    }

    public void setTypeFace() {
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/SourceSansPro-Light.ttf");
        setTypeface(typeface, 1);
    }
}

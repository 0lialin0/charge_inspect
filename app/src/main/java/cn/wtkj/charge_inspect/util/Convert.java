package cn.wtkj.charge_inspect.util;

import android.content.Context;

public class Convert {
	public static int dip2px(Context context, float dipValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dipValue * scale + 0.5f);
	}
}

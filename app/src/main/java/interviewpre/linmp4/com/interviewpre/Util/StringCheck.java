package interviewpre.linmp4.com.interviewpre.Util;

import android.os.Environment;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 字符串格式检查
 */
public class StringCheck {

    public static String tempJson;

    public static boolean isMobileNO(String mobiles) {
    /*
    移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
    联通：130、131、132、152、155、156、185、186
    电信：133、153、180、189、（1349卫通）
    总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
    */
//        String telRegex = "[1][3578]\\d{9}";//"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        String telRegex = "^(13[0-9]|15[0-9]|17[0-9]|18[0-9]|14[0-9])[0-9]{8}$";
        return !isEmpty(mobiles) && mobiles.matches(telRegex);
    }

    public static boolean isPrice(String str) {
        String regex = "[0-9]+(.[0-9]+)?";
        return !isEmpty(str) && str.matches(regex);
    }

    public static boolean isWorkPhone(String str) {
        String regex = "[0-9-]+";
        return !isEmpty(str) && str.matches(regex);
    }

    public static boolean isCornet(String str) {
        String regex = "\\d{3,6}";
        return !isEmpty(str) && str.matches(regex);
    }

    public static boolean isStation(String str) {
        String regex = ".{1,30}";
        return !isEmpty(str) && str.matches(regex);
    }

    public static boolean isEmpty(CharSequence str) {
        return (str == null || str.length() == 0 || "".equals(str.toString().replace(" ", "")));
    }

    public static boolean isPassword(String str) {
        String regex = "[a-zA-Z0-9]{1,20}";
        return !isEmpty(str) && str.matches(regex);
    }

    public static boolean isEmail(String str) {
        String regex = "^[a-z]([a-z0-9]*[-_]?[a-z0-9]+)*@([a-z0-9]*[-_]?[a-z0-9]+)+[\\.][a-z]{2,3}([\\.][a-z]{2})?$";
        return !isEmpty(str) && str.matches(regex);
    }

    public static boolean isWeight(String str) {
        String regex = "\\d*.?\\d{1}";
        return !isEmpty(str) && str.matches(regex);
    }

    public static boolean isTenInt(String str) {
        String regex = "^\\d{10}$";
        return !isEmpty(str) && str.matches(regex);
    }

    public static boolean isUrl(String str) {
        String regex = "^(http|https|ftp)\\://[a-zA-Z0-9\\-\\.]+\\.[a-zA-Z]{2,3}(:[a-zA-Z0-9]*)?/?([a-zA-Z0-9\\-\\._\\?\\,\\'/\\\\\\+&%\\$#\\=~])*$";
        String regex2 = "^(http|https|ftp)\\://((0|(?:[1-9]\\d{0,1})|(?:1\\d{2})|(?:2[0-4]\\d)|(?:25[0-5]))\\.){3}((?:[1-9]\\d{0,1})|(?:1\\d{2})|(?:2[0-4]\\d)|(?:25[0-5]))(:\\d{2,5})?$";
        return !isEmpty(str) && (str.matches(regex) || str.matches(regex2));
    }

    public static boolean sizeIn(String str, int min, int max) {
        String regex = ".{" + min + "," + max + "}";

        if (isEmpty(str)) {
            str = "";
        }

        return str.matches(regex);
    }

    /**
     * 可以负号，小数点后一位
     */
    public static String isMinInt = "([-]?[0-9]+[.]?[0-9]?)|[-]";
    /**
     * 可以负号，小数点后两位
     */
    public static String isMinInt2 = "([-]?[0-9]+[.]?[0-9]?[0-9]?)|[-]";
    /**
     * 小数点后两位
     */
    public static String isMinInt3 = "([0-9]+[.]?[0-9]?[0-9]?)";
    /**
     * 数字或字母
     */
    public static String isNmuLetter = "[A-Za-z0-9]*";

    /**
     * 正则表达式
     */
    public static InputFilter EditTextFilter(final String regex) {
        return new InputFilter() {
            public CharSequence filter(CharSequence source, int start, int end,
                                       Spanned dest, int dstart, int dend) {
                // 删除等特殊字符，直接返回
                if ("".equals(source.toString())) {
                    return null;
                }
                if (!(dest.toString() + source.toString()).matches(regex)) {
                    return "";
                }
                return source;
            }
        };
    }


    /**
     * 检查设备是否存在SDCard的工具方法
     */
    public static boolean hasSdcard() {
        String state = Environment.getExternalStorageState(); // 有存储的SDCard
        return state.equals(Environment.MEDIA_MOUNTED);
    }

    public static String Date2Str(String date) {
        String[] temp = date.split("T");
        if (temp.length == 2) {
            return temp[0];
        }
        return "";
    }

    public static String Date2Str2(String date) {
        String temp = date.replace("T", " ");
        String[] temp2 = temp.split("\\.");
        if (temp2.length == 2) {
            return temp2[0];
        }
        return temp;
    }

    public static int Str2int(String str) {
        return (str.equals("") ? 0 : Integer.parseInt(str));
    }

    /**
     * 右补位，左对齐
     *
     * @param oriStr 原字符串
     * @param len    目标字符串长度
     * @param alexin 补位字符
     * @return 目标字符串
     */
    public static String padRight(String oriStr, int len, char alexin) {
        int strlen = oriStr.length();
        String str = "";
        if (strlen < len) {
            for (int i = 0; i < len - strlen; i++) {
                str = str + alexin;
            }
        }
        str = str + oriStr;
        return str;
    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }
        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight() * 3;
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

    public static String Tojson(String json) throws JSONException {
        if (StringCheck.isEmpty(json)) {
            return null;
        }
        String message = null;
        try {
            json = json.trim();
            if (json.startsWith("{")) {
                JSONObject jsonObject = new JSONObject(json);
                message = jsonObject.toString(4);
            }
            if (json.startsWith("[")) {
                JSONArray jsonArray = new JSONArray(json);
                message = jsonArray.toString(4);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return message;
    }

    public abstract static class UpdateUI {
        public abstract void Success(String temp);

        public UpdateUI(String response, int code, String url, LinkedHashMap<String, String> formMap) {
            String temp = null;
            if (code == -1) {
                temp = response;
            } else {
                try {
                    temp = StringCheck.Tojson(response);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            String a = "";
            if (formMap != null) {
                a += "\n\n参数:\n";
                for (final Map.Entry<String, String> entry : formMap.entrySet()) {
                    a += "\"" + entry.getKey() + "\" : \"" + entry.getValue() + "\"\n";
                }
            }
            if (temp == null) {
                Success(response);
            } else {
                temp = "请求连接：\n" + url + "\n\n状态码：" + code + a + "\n\n返回结果:\n" + temp;
                Success(temp);
            }
        }
    }
}

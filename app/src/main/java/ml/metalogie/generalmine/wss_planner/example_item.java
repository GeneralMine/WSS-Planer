package ml.metalogie.generalmine.wss_planner;

public class example_item {
    private int mImageResource;
    private String mText1;
    private String mText2;

    public example_item(int imageResource, String text1, String text2) {
        mImageResource=imageResource;
        mText1=text1;
        mText2=text2;
    }

    public int getmImageResource() {
        return  mImageResource;
    }

    public  String gettext1() {
        return mText1;
    }

    public String gettext2() {
        return mText2;
    }
}

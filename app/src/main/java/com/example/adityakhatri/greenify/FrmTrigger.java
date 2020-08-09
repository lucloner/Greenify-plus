package com.example.adityakhatri.greenify;


import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FrmTrigger extends Fragment {


    public FrmTrigger() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frm_trigger, container, false);





    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        class OnSwipeTouchListener implements View.OnTouchListener {

            private final GestureDetector gestureDetector;

            public OnSwipeTouchListener (Context ctx){
                gestureDetector = new GestureDetector(ctx, new GestureListener());
            }

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector.onTouchEvent(event);
            }

            final class GestureListener extends GestureDetector.SimpleOnGestureListener {

                private static final int SWIPE_THRESHOLD = 100;
                private static final int SWIPE_VELOCITY_THRESHOLD = 100;

                @Override
                public boolean onDown(MotionEvent e) {
                    return true;
                }

                @Override
                public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                    boolean result = false;
                    try {
                        float diffY = e2.getY() - e1.getY();
                        float diffX = e2.getX() - e1.getX();
                        if (Math.abs(diffX) > Math.abs(diffY)) {
                            if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                                if (diffX > 0) {
                                    onSwipeRight();
                                } else {
                                    onSwipeLeft();
                                }
                                result = true;
                            }
                        }
                        else if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                            if (diffY > 0) {
                                onSwipeBottom();
                            } else {
                                onSwipeTop();
                            }
                            result = true;
                        }
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    return result;
                }
            }

            public void onSwipeRight() {

            }

            public void onSwipeLeft() {
            }

            public void onSwipeTop() {
            }

            public void onSwipeBottom() {
            }


        }


        ImageView iv1= view.findViewById(R.id.iv1);
        iv1.setOnTouchListener(new OnSwipeTouchListener(getActivity()) {




            public void onSwipeTop() {

                Intent intent = getActivity().getPackageManager().getLaunchIntentForPackage("com.whatsapp");
                if (intent != null) {
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);//null pointer check in case package name was not found
                }
                else
                {
                    onGoToAnotherInAppStore(intent, "com.whatsapp");
                }



                Toast.makeText(getActivity(),"top",Toast.LENGTH_SHORT).show();
            }

            public void onGoToAnotherInAppStore(Intent intent, String appPackageName)
            {
                try {

                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setData(Uri.parse("market://details?id=" + appPackageName));
                    startActivity(intent);

                } catch (android.content.ActivityNotFoundException anfe) {

                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setData(Uri.parse("http://play.google.com/store/apps/details?id=" + appPackageName));
                    startActivity(intent);

                }

            }


            public void onSwipeRight() {
                Intent intent = getActivity().getPackageManager().getLaunchIntentForPackage("com.miui.calculator");
                if (intent != null) {
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);//null pointer check in case package name was not found
                }
                else
                {
                    onGoToAnotherInAppStore(intent, "com.android.calculator2");
                }



                Toast.makeText(getActivity(), "right", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeLeft() {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com"));
                startActivity(browserIntent);
                Toast.makeText(getActivity(), "left", Toast.LENGTH_SHORT).show();
            }
            int i=1;
            public void onSwipeBottom() {
                if(i%2==0)
                {
                    WifiManager wifi = (WifiManager) getActivity().getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                    wifi.setWifiEnabled(true);
                    i++;
                    Toast.makeText(getActivity(), "Wifi On", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    WifiManager wifi = (WifiManager) getActivity().getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                    wifi.setWifiEnabled(false);
                    i++;
                    Toast.makeText(getActivity(), "Wifi Off", Toast.LENGTH_SHORT).show();

                }

            }



        });


    }
}

package com.sampleboard.utils;

/**
 * Created by Mobilyte India Pvt Ltd on 2/28/2017.
 */

public interface Constants {
    // Environment to use when creating an instance of Wallet.WalletOptions

    /*
    API BASE URL
     */
    String LIVE_APIURL = "http://starlord.hackerearth.com/";
    String DEV_APIURL = "http://10.20.3.169:8080/";

    String API_BASE_URL = DEV_APIURL;

    String DEF_PROFILE_URL = "https://organicthemes.com/demo/profile/files/2012/12/profile_img.png";

    String MUSIC_API = "edfora/cokestudio";

    String LOGIN_API = "api/login";
    String REGISTER_API = "api/register";
    String GET_TIMELINE_API = "api/get_timeline";
    String GET_PROFILE = "api/get_profile";
    String UPDATE_PROFILE = "api/update_profile";
    String UPDATE_PROFILE_PIC = "api/upload_profile_pic";






    //services action name
    String ACTION_PLAY = "com.action.PLAY";
    String BROADCAST_MUSIC_PLAY = "com.music.play";
    String BROADCAST_MUSIC_DOWNLOAD = "com.music.download";
    String BROADCAST_HANDLE_NEW_REQUEST = "com.music.manage.download";

    public interface MusicAction {
        String PLAY_PREVIOUS = "com.play.previous";
        String PLAY_NEXT = "com.play.next";
        String TOGGLE = "com.play.toggle";
        String PLAY_UPDATE_ACTION = "com.foregroundservice.action.play.update";   //update from ui to notification
    }

    String DESTINATION = "destination";

    String SEARCH_SCREEN = "SEARCH_SCREEN";
    String DETAIL_SCREEN = "DETAIL_SCREEN";

    String OBJ_DETAIL = "obj_detail";
    String POSITION = "POSITION";
    String OBJ_BITMAP = "obj_bitmap";
    String PATH_IMAGE = "path_image";


    interface ACTION {
        String MAIN_ACTION = "com.foregroundservice.action.main";
        String INIT_ACTION = "com.foregroundservice.action.init";
        String PREV_ACTION = "com.foregroundservice.action.prev";
        String PLAY_ACTION = "com.foregroundservice.action.play";

        String NEXT_ACTION = "com.foregroundservice.action.next";
        String STARTFOREGROUND_ACTION = "com.foregroundservice.action.startforeground";
        String STOPFOREGROUND_ACTION = "com.foregroundservice.action.stopforeground";
    }

    interface NOTIFICATION_ID {
        int FOREGROUND_SERVICE = 101;
    }

}

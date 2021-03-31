package com.bos.vrLauncher

import android.content.ComponentName
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val dropdown = findViewById<Spinner>(R.id.spinner)
        val selectedText = findViewById<TextView>(R.id.selectedText)
        val goButton = findViewById<Button>(R.id.goButton)

        val items = arrayOf("ALL_EVENTS", "ASSISTANT", "AUI_INTERNAL_SETTINGS", "AUI_CHATS", "AUI_MESSENGER", "AUI_PARTIES", "AUI_PEOPLE", "AUI_PEOPLE_FB", "AUI_PROFILE", "AUI_SOCIAL", "AUI_SOCIAL_REAUTH", "AUI_SOCIAL_V2", "AUI_SOCIAL_SETTINGS", "AUI_TABLET_NONE", "AVATAR_EDITOR", "BLOCKANDREPORT", "BLUETOOTH", "BUG_REPORT", "CAMERA_ROLL", "CAPTIVE_WIFI_PORTAL", "DATE_TIME_SETTINGS", "DEFAULT_BROWSER", "DEVICE_BATTERY", "EVENTS", "FBCONNECT", "FRIENDS", "GAMING_ACTIVITY", "GROUP_LAUNCH_APP_SELECTOR", "GROUP_LAUNCH_DESTINATION_SELECTOR", "HAND_TRACKING_NUX", "HEALTH_AND_SAFETY", "HOME", "HOME_FIRST_TIME_NUX", "INSTALLER", "INVITE_FRIENDS", "INVITE_TO_APP", "LAUNCH_IAP", "LIBRARY", "LIVESTREAMING", "LOCKPATTERN", "MEDIA_PREVIEW", "MESSAGES", "NOTIFICATIONS", "PARTIES", "PAUSE", "PERMISSIONS", "PRESENCE_INVITE", "PROFILE", "PROFILE_PHOTO_EDITOR", "QUICK_MESSAGE", "REMOTE_SYSTEM_ACTION_REDIRECT", "SEARCH", "SETTINGS", "SHARE_MEDIA", "SHARE_SHEET", "SHARE_SHEET_V2", "SHARING", "SOCIAL", "SOCIAL_ADD_FRIENDS", "SOCIAL_OVERLAY_PANEL", "SOCIAL_REQUESTS", "STORAGE_MANAGER", "STORE", "TV", "UNINSTALLER", "UNLOCK_PATTERN", "USER_BLOCK", "USER_FRIEND_REQUEST", "USER_PROFILE", "USER_REPORT", "USER_UNBLOCK", "WIFI", "NONE", "APP_DOWNLOAD_FAILURE_LOW_STORAGE", "APP_MODE_INCOMPATIBLE", "APP_LAUNCH_BLOCKED_CONTROLLER_REQUIRED", "APP_LAUNCH_BLOCKED_HANDS_REQUIRED", "CONTROLLER_PAIRING", "ENTERPRISE_CERTIFICATE_EXPIRED", "ENTERPRISE_CERTIFICATE_EXPIRING_WARNING", "ENTERPRISE_GUARDIAN_DISABLED_WARNING", "ENTERPRISE_KIOSK_NOT_INSTALLED", "FACEBOOK_BLOCK", "FIRST_TIME_NUX", "FITNESS_TRACKER", "GUARDIAN_DIALOG", "GUARDIAN_DIALOG_ROOMSCALE_URI", "GUARDIAN_DIALOG_SWITCH_ROOMSCALE_URI", "GUARDIAN_DIALOG_STATIONARY_URI", "GUARDIAN_ADJUST_DIALOG", "GUARDIAN_ADJUST_FLOOR", "GUARDIAN_ADJUST_SETUP", "GUARDIAN_CLEAR_HISTORY", "GUARDIAN_CLEAR_SURFACES", "GUARDIAN_CREATE_SURFACE", "GUARDIAN_CREATE_DESK", "INTRUSION_DETECTION_NUX", "IPD_ADJUST", "KEYBOARD", "LAUNCH_CHECK_APP_DEGRADED", "LAUNCH_CHECK_APP_DISABLED", "LAUNCH_CHECK_APP_UPDATE", "LAUNCH_CHECK_BLOCK_DESK", "LAUNCH_CHECK_CLOUD_STORAGE", "LAUNCH_CHECK_REQUIRES_6DOF", "LAUNCH_CHECK_REQUIRES_AVATAR", "LAUNCH_CHECK_REQUIRES_CONTROLLERS", "LAUNCH_CHECK_REQUIRES_EXCLUSIVE_MICROPHONE", "LAUNCH_CHECK_REQUIRES_HANDS", "LOCAL_STREAM_PRIVACY_CHECK_DIALOG", "LOCAL_STREAM_START_FROM_DEVICE_DIALOG", "LOCAL_STREAM_STOP_FROM_DEVICE_DIALOG", "LOCAL_STREAM_TO_BROWSER_DIALOG", "LOGIN", "MESSENGER_INTEGRITY", "OCULUS_LINK_AVAILABLE", "OCULUS_LINK_DISCONNECTED", "PANEL_REORIENT", "PASSTHROUGH_PORTAL", "PT_ONDEMAND_NUX_DIALOG", "QUEST_VIEW_RECENTER", "QUEST_SHOW_TASKBAR", "QUIT_AND_LAUNCH", "SOCIAL_JOIN_PARTY", "SOCIAL_CONFIRM_JOIN_PARTY", "SOCIAL_CREATE_PARTY_PREVIEW", "SOCIAL_CREATE_VR_INVITE_DIALOG", "JOIN_PARTY_DIALOG", "SOCIAL_PARTY_PRIVACY", "SOCIAL_RECEIVE_INVITE_DIALOG", "STATIONARY_GUARDIAN_V2_NUX", "STATIONARY_GUARDIAN_V2_NUX_USING_ROOMSCALE", "SYSTEM_FAILURE_MESSAGE", "TRACKING_MODE_3DOF_INCOMPAT_DIALOG", "TRACKING_OFF_DIALOG", "UNIVERSAL_SHARE_SHEET", "UNOFFICIAL_APP_INSTALLED_DIALOG", "UNOFFICIAL_APP_LAUNCHED_DIALOG")
        val results = arrayOf("systemux://all_events", "systemux://assistant", "systemux://aui-internal-settings", "systemux://aui-chats", "systemux://aui-messenger", "systemux://aui-parties", "systemux://aui-people", "systemux://aui-people-fb", "systemux://aui-profile", "systemux://aui-social", "systemux://aui-social-reauth", "systemux://aui-social-v2", "systemux://aui-social-settings", "systemux://aui-tablet-none", "systemux://avatareditor", "systemux://blockandreport", "systemux://bluetooth", "systemux://bug_report", "systemux://cameraroll", "systemux://captive-wifi-portal", "systemux://datetime", "systemux://browser", "systemux://devicebattery", "systemux://events", "systemux://fb-connect", "systemux://friends", "systemux://gaming-activity", "systemux://group_launch_app_selector", "systemux://group_launch_destination_selector", "systemux://hand-tracking-nux", "systemux://health_and_safety_video", "systemux://home", "systemux://home-first-time-nux", "systemux://installer", "systemux://invite_friends", "systemux://invite_to_app", "systemux://launch_iap", "systemux://library", "systemux://livestreaming", "systemux://unlockpattern", "systemux://media_preview", "systemux://messages", "systemux://notifications", "systemux://parties", "systemux://pause", "systemux://permissions", "systemux://presence_invite", "systemux://profile", "systemux://profile_photo_editor", "systemux://quick_message", "systemux://remote_system_action_redirect", "systemux://search", "systemux://settings", "systemux://share_media", "systemux://share_sheet", "systemux://share_sheet_v2", "systemux://sharing", "systemux://social", "systemux://social_add_friends", "systemux://social_overlay_panel", "systemux://social_requests", "systemux://storage_manager", "systemux://store", "systemux://tv", "systemux://uninstaller", "systemux://unlockpattern", "systemux://user_block", "systemux://user_friend_request", "systemux://user_profile", "systemux://user_report", "systemux://user_unblock", "systemux://wifi", "systemux://dialog/none", "systemux://dialog/app-download-failure-low-storage", "systemux://dialog/app_mode_incompat", "systemux://dialog/app_launch_blocked_controller_required", "systemux://dialog/app_launch_blocked_hands_required", "systemux://dialog/controller-pairing", "systemux://dialog/enterprise-certificate-expired", "systemux://dialog/enterprise-certificate-expiring-warning", "systemux://dialog/enterprise-guardian-disabled-warning", "systemux://dialog/enterprise-kiosk-not-installed", "systemux://dialog/facebook-block", "systemux://first-time-nux", "systemux://fitness-tracker", "systemux://guardian/setup", "systemux://guardian/roomscale-setup", "systemux://guardian/switch-roomscale", "systemux://guardian/stationary-setup", "systemux://dialog/guardian-adjust", "systemux://guardian/guardian-adjust-floor", "systemux://guardian/adjust-setup", "systemux://guardian/guardian-clear-history", "systemux://guardian/guardian-clear-surfaces", "systemux://guardian/guardian-create-surface", "systemux://guardian/guardian-create-desk", "systemux://dialog/intrusion-detection-nux", "systemux://dialog/ipd-adjust", "systemux://keyboard", "systemux://dialog/launch-check-app-degraded", "systemux://dialog/launch-check-app-disabled", "systemux://dialog/launch-check-app-update", "systemux://dialog/launch-check-block-desk", "systemux://dialog/launch-check-cloud-storage", "systemux://dialog/launch-check-requires-6dof", "systemux://dialog/launch-check-requires-avatar", "systemux://dialog/launch-check-requires-controllers", "systemux://dialog/launch-check-requires-exclusive-microphone", "systemux://dialog/launch-check-requires-hands", "systemux://dialog/local-stream-privacy-check", "systemux://dialog/local-stream-start-from-device", "systemux://dialog/local-stream-stop-from-device", "systemux://dialog/local-stream-to-browser-dialog", "systemux://login", "systemux://dialog/messenger-integrity", "systemux://dialog/oculus_link_available", "systemux://dialog/oculus_link_disconnected", "systemux://dialog/panel-reorient", "systemux://guardian/passthrough-portal", "systemux://dialog/pt-ondemand-nux", "systemux://dialog/quest-view-recenter", "systemux://dialog/quest-show-taskbar", "systemux://dialog/quit-and-launch", "systemux://dialog/social-join-party", "systemux://dialog/social-confirm-join-party", "systemux://dialog/create-party-preview", "systemux://dialog/create-vr-invite", "systemux://social-join-party", "systemux://dialog/social-party-privacy", "systemux://dialog/social-receive-invite", "systemux://dialog/stationary-guardian-v2-nux", "systemux://dialog/stationary-guardian-v2-nux-using-roomscale", "systemux://dialog/system-failure", "systemux://dialog/tracking-mode-3dof-incompat", "systemux://dialog/tracking-off", "systemux://universal-share-sheet", "systemux://dialog/unofficial-app-installed", "systemux://dialog/unofficial-app-launched")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items)
        dropdown.adapter = adapter

        dropdown.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View,
                                        position: Int, id: Long) {
                Log.v("item", results[position])
                selectedText.text = results[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        goButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.component = ComponentName("com.oculus.vrshell", "com.oculus.vrshell.MainActivity")
            intent.data = Uri.parse(selectedText.text as String?)
            this.startActivity(intent)
        }
    }
}
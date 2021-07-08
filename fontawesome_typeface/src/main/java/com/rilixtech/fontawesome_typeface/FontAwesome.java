package com.rilixtech.fontawesome_typeface;

import com.rilixtech.materialfancybutton.typeface.IIcon;
import com.rilixtech.materialfancybutton.typeface.ITypeface;
import ohos.agp.text.Font;
import ohos.app.AbilityContext;
import ohos.app.Context;
import ohos.global.resource.RawFileDescriptor;
import ohos.global.resource.RawFileEntry;
import ohos.global.resource.Resource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

public class FontAwesome implements ITypeface {
    private static final String TTF_FILE = "fontawesome-font-v4.7.ttf";
    private static final String MAPPING_FONT_PREFIX = "fawi";

    private static Font typeface = null;

    private static HashMap<String, Character> mChars;

    @Override public IIcon getIcon(String key) {
        return Icon.valueOf(key);
    }

    @Override public HashMap<String, Character> getCharacters() {
        if (mChars == null) {
            HashMap<String, Character> aChars = new HashMap<String, Character>();
            for (Icon v : Icon.values()) {
                aChars.put(v.name(), v.character);
            }
            mChars = aChars;
        }

        return mChars;
    }

    @Override public String getMappingPrefix() {
        return MAPPING_FONT_PREFIX;
    }

    @Override public String getFontName() {
        return "FontAwesome";
    }

    @Override public String getVersion() {
        return "4.7.0.0";
    }

    @Override public int getIconCount() {
        return mChars.size();
    }

    @Override public Collection<String> getIcons() {
        Collection<String> icons = new LinkedList<String>();

        for (Icon value : Icon.values()) {
            icons.add(value.name());
        }

        return icons;
    }

    @Override public String getAuthor() {
        return "Dave Gandy";
    }

    @Override public String getUrl() {
        return "https://github.com/FortAwesome/Font-Awesome";
    }

    @Override public String getDescription() {
        return "Font Awesome is a full suite of 675 pictographic icons for easy scalable vector graphics on websites, created and maintained by Dave Gandy. Stay up to date @fontawesome.";
    }

    @Override public String getLicense() {
        return "SIL OFL 1.1";
    }

    @Override public String getLicenseUrl() {
        return "http://scripts.sil.org/OFL";
    }

    @Override
    public Font getTypeface(AbilityContext context) {
        if (typeface == null) {
            RawFileEntry rawFileEntry = context.getResourceManager()
                    .getRawFileEntry("resources/rawfile/" + TTF_FILE);
            try {
                File file = getFileFromRawFile(context, rawFileEntry, "file_" + TTF_FILE);
                Font.Builder newTypeface = new Font.Builder(file);
                Font builtFont = newTypeface.build();
                typeface = builtFont;
                return builtFont;
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
        return  typeface;
    }

    private File getFileFromRawFile(AbilityContext ctx, RawFileEntry rawFileEntry, String filename) {
        byte[] buf = null;
        try (Resource resource = rawFileEntry.openRawFile();
             RawFileDescriptor rawFileDescriptor = rawFileEntry.openRawFileDescriptor();) {
            File file = new File(ctx.getCacheDir(), filename);

            buf = new byte[(int) rawFileDescriptor.getFileSize()];
            int bytesRead = resource.read(buf);
            if (bytesRead != buf.length) {
                throw new IOException("Asset read failed");
            }
            FileOutputStream output = new FileOutputStream(file);
            output.write(buf, 0, bytesRead);
            output.close();
            return file;
        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }

    public enum Icon implements IIcon {
        fawi_glass('\uf000'),
        fawi_music('\uf001'),
        fawi_search('\uf002'),
        fawi_envelope_o('\uf003'),
        fawi_heart('\uf004'),
        fawi_star('\uf005'),
        fawi_star_o('\uf006'),
        fawi_user('\uf007'),
        fawi_film('\uf008'),
        fawi_th_large('\uf009'),
        fawi_th('\uf00a'),
        fawi_th_list('\uf00b'),
        fawi_check('\uf00c'),
        fawi_times('\uf00d'),
        fawi_search_plus('\uf00e'),
        fawi_search_minus('\uf010'),
        fawi_power_off('\uf011'),
        fawi_signal('\uf012'),
        fawi_cog('\uf013'),
        fawi_trash_o('\uf014'),
        fawi_home('\uf015'),
        fawi_file_o('\uf016'),
        fawi_clock_o('\uf017'),
        fawi_road('\uf018'),
        fawi_download('\uf019'),
        fawi_arrow_circle_o_down('\uf01a'),
        fawi_arrow_circle_o_up('\uf01b'),
        fawi_inbox('\uf01c'),
        fawi_play_circle_o('\uf01d'),
        fawi_repeat('\uf01e'),
        fawi_refresh('\uf021'),
        fawi_list_alt('\uf022'),
        fawi_lock('\uf023'),
        fawi_flag('\uf024'),
        fawi_headphones('\uf025'),
        fawi_volume_off('\uf026'),
        fawi_volume_down('\uf027'),
        fawi_volume_up('\uf028'),
        fawi_qrcode('\uf029'),
        fawi_barcode('\uf02a'),
        fawi_tag('\uf02b'),
        fawi_tags('\uf02c'),
        fawi_book('\uf02d'),
        fawi_bookmark('\uf02e'),
        fawi_print('\uf02f'),
        fawi_camera('\uf030'),
        fawi_font('\uf031'),
        fawi_bold('\uf032'),
        fawi_italic('\uf033'),
        fawi_text_height('\uf034'),
        fawi_text_width('\uf035'),
        fawi_align_left('\uf036'),
        fawi_align_center('\uf037'),
        fawi_align_right('\uf038'),
        fawi_align_justify('\uf039'),
        fawi_list('\uf03a'),
        fawi_outdent('\uf03b'),
        fawi_indent('\uf03c'),
        fawi_video_camera('\uf03d'),
        fawi_picture_o('\uf03e'),
        fawi_pencil('\uf040'),
        fawi_map_marker('\uf041'),
        fawi_adjust('\uf042'),
        fawi_tint('\uf043'),
        fawi_pencil_square_o('\uf044'),
        fawi_share_square_o('\uf045'),
        fawi_check_square_o('\uf046'),
        fawi_arrows('\uf047'),
        fawi_step_backward('\uf048'),
        fawi_fast_backward('\uf049'),
        fawi_backward('\uf04a'),
        fawi_play('\uf04b'),
        fawi_pause('\uf04c'),
        fawi_stop('\uf04d'),
        fawi_forward('\uf04e'),
        fawi_fast_forward('\uf050'),
        fawi_step_forward('\uf051'),
        fawi_eject('\uf052'),
        fawi_chevron_left('\uf053'),
        fawi_chevron_right('\uf054'),
        fawi_plus_circle('\uf055'),
        fawi_minus_circle('\uf056'),
        fawi_times_circle('\uf057'),
        fawi_check_circle('\uf058'),
        fawi_question_circle('\uf059'),
        fawi_info_circle('\uf05a'),
        fawi_crosshairs('\uf05b'),
        fawi_times_circle_o('\uf05c'),
        fawi_check_circle_o('\uf05d'),
        fawi_ban('\uf05e'),
        fawi_arrow_left('\uf060'),
        fawi_arrow_right('\uf061'),
        fawi_arrow_up('\uf062'),
        fawi_arrow_down('\uf063'),
        fawi_share('\uf064'),
        fawi_expand('\uf065'),
        fawi_compress('\uf066'),
        fawi_plus('\uf067'),
        fawi_minus('\uf068'),
        fawi_asterisk('\uf069'),
        fawi_exclamation_circle('\uf06a'),
        fawi_gift('\uf06b'),
        fawi_leaf('\uf06c'),
        fawi_fire('\uf06d'),
        fawi_eye('\uf06e'),
        fawi_eye_slash('\uf070'),
        fawi_exclamation_triangle('\uf071'),
        fawi_plane('\uf072'),
        fawi_calendar('\uf073'),
        fawi_random('\uf074'),
        fawi_comment('\uf075'),
        fawi_magnet('\uf076'),
        fawi_chevron_up('\uf077'),
        fawi_chevron_down('\uf078'),
        fawi_retweet('\uf079'),
        fawi_shopping_cart('\uf07a'),
        fawi_folder('\uf07b'),
        fawi_folder_open('\uf07c'),
        fawi_arrows_v('\uf07d'),
        fawi_arrows_h('\uf07e'),
        fawi_bar_chart('\uf080'),
        fawi_twitter_square('\uf081'),
        fawi_facebook_square('\uf082'),
        fawi_camera_retro('\uf083'),
        fawi_key('\uf084'),
        fawi_cogs('\uf085'),
        fawi_comments('\uf086'),
        fawi_thumbs_o_up('\uf087'),
        fawi_thumbs_o_down('\uf088'),
        fawi_star_half('\uf089'),
        fawi_heart_o('\uf08a'),
        fawi_sign_out('\uf08b'),
        fawi_linkedin_square('\uf08c'),
        fawi_thumb_tack('\uf08d'),
        fawi_external_link('\uf08e'),
        fawi_sign_in('\uf090'),
        fawi_trophy('\uf091'),
        fawi_github_square('\uf092'),
        fawi_upload('\uf093'),
        fawi_lemon_o('\uf094'),
        fawi_phone('\uf095'),
        fawi_square_o('\uf096'),
        fawi_bookmark_o('\uf097'),
        fawi_phone_square('\uf098'),
        fawi_twitter('\uf099'),
        fawi_facebook('\uf09a'),
        fawi_github('\uf09b'),
        fawi_unlock('\uf09c'),
        fawi_credit_card('\uf09d'),
        fawi_rss('\uf09e'),
        fawi_hdd_o('\uf0a0'),
        fawi_bullhorn('\uf0a1'),
        fawi_bell_o('\uf0a2'),
        fawi_certificate('\uf0a3'),
        fawi_hand_o_right('\uf0a4'),
        fawi_hand_o_left('\uf0a5'),
        fawi_hand_o_up('\uf0a6'),
        fawi_hand_o_down('\uf0a7'),
        fawi_arrow_circle_left('\uf0a8'),
        fawi_arrow_circle_right('\uf0a9'),
        fawi_arrow_circle_up('\uf0aa'),
        fawi_arrow_circle_down('\uf0ab'),
        fawi_globe('\uf0ac'),
        fawi_wrench('\uf0ad'),
        fawi_tasks('\uf0ae'),
        fawi_filter('\uf0b0'),
        fawi_briefcase('\uf0b1'),
        fawi_arrows_alt('\uf0b2'),
        fawi_users('\uf0c0'),
        fawi_link('\uf0c1'),
        fawi_cloud('\uf0c2'),
        fawi_flask('\uf0c3'),
        fawi_scissors('\uf0c4'),
        fawi_files_o('\uf0c5'),
        fawi_paperclip('\uf0c6'),
        fawi_floppy_o('\uf0c7'),
        fawi_square('\uf0c8'),
        fawi_bars('\uf0c9'),
        fawi_list_ul('\uf0ca'),
        fawi_list_ol('\uf0cb'),
        fawi_strikethrough('\uf0cc'),
        fawi_underline('\uf0cd'),
        fawi_table('\uf0ce'),
        fawi_magic('\uf0d0'),
        fawi_truck('\uf0d1'),
        fawi_pinterest('\uf0d2'),
        fawi_pinterest_square('\uf0d3'),
        fawi_google_plus_square('\uf0d4'),
        fawi_google_plus('\uf0d5'),
        fawi_money('\uf0d6'),
        fawi_caret_down('\uf0d7'),
        fawi_caret_up('\uf0d8'),
        fawi_caret_left('\uf0d9'),
        fawi_caret_right('\uf0da'),
        fawi_columns('\uf0db'),
        fawi_sort('\uf0dc'),
        fawi_sort_desc('\uf0dd'),
        fawi_sort_asc('\uf0de'),
        fawi_envelope('\uf0e0'),
        fawi_linkedin('\uf0e1'),
        fawi_undo('\uf0e2'),
        fawi_gavel('\uf0e3'),
        fawi_tachometer('\uf0e4'),
        fawi_commenti_o('\uf0e5'),
        fawi_comments_o('\uf0e6'),
        fawi_bolt('\uf0e7'),
        fawi_sitemap('\uf0e8'),
        fawi_umbrella('\uf0e9'),
        fawi_clipboard('\uf0ea'),
        fawi_lightbulb_o('\uf0eb'),
        fawi_exchange('\uf0ec'),
        fawi_cloud_download('\uf0ed'),
        fawi_cloud_upload('\uf0ee'),
        fawi_user_md('\uf0f0'),
        fawi_stethoscope('\uf0f1'),
        fawi_suitcase('\uf0f2'),
        fawi_bell('\uf0f3'),
        fawi_coffee('\uf0f4'),
        fawi_cutlery('\uf0f5'),
        fawi_file_text_o('\uf0f6'),
        fawi_building_o('\uf0f7'),
        fawi_hospital_o('\uf0f8'),
        fawi_ambulance('\uf0f9'),
        fawi_medkit('\uf0fa'),
        fawi_fighter_jet('\uf0fb'),
        fawi_beer('\uf0fc'),
        fawi_h_square('\uf0fd'),
        fawi_plus_square('\uf0fe'),
        fawi_angle_double_left('\uf100'),
        fawi_angle_double_right('\uf101'),
        fawi_angle_double_up('\uf102'),
        fawi_angle_double_down('\uf103'),
        fawi_angle_left('\uf104'),
        fawi_angle_right('\uf105'),
        fawi_angle_up('\uf106'),
        fawi_angle_down('\uf107'),
        fawi_desktop('\uf108'),
        fawi_laptop('\uf109'),
        fawi_tablet('\uf10a'),
        fawi_mobile('\uf10b'),
        fawi_circle_o('\uf10c'),
        fawi_quote_left('\uf10d'),
        fawi_quote_right('\uf10e'),
        fawi_spinner('\uf110'),
        fawi_circle('\uf111'),
        fawi_reply('\uf112'),
        fawi_github_alt('\uf113'),
        fawi_folder_o('\uf114'),
        fawi_folder_open_o('\uf115'),
        fawi_smile_o('\uf118'),
        fawi_frown_o('\uf119'),
        fawi_meh_o('\uf11a'),
        fawi_gamepad('\uf11b'),
        fawi_keyboard_o('\uf11c'),
        fawi_flag_o('\uf11d'),
        fawi_flag_checkered('\uf11e'),
        fawi_terminal('\uf120'),
        fawi_code('\uf121'),
        fawi_reply_all('\uf122'),
        fawi_star_half_o('\uf123'),
        fawi_location_arrow('\uf124'),
        fawi_crop('\uf125'),
        fawi_code_fork('\uf126'),
        fawi_chain_broken('\uf127'),
        fawi_question('\uf128'),
        fawi_info('\uf129'),
        fawi_exclamation('\uf12a'),
        fawi_superscript('\uf12b'),
        fawi_subscript('\uf12c'),
        fawi_eraser('\uf12d'),
        fawi_puzzle_piece('\uf12e'),
        fawi_microphone('\uf130'),
        fawi_microphone_slash('\uf131'),
        fawi_shield('\uf132'),
        fawi_calendar_o('\uf133'),
        fawi_fire_extinguisher('\uf134'),
        fawi_rocket('\uf135'),
        fawi_maxcdn('\uf136'),
        fawi_chevron_circle_left('\uf137'),
        fawi_chevron_circle_right('\uf138'),
        fawi_chevron_circle_up('\uf139'),
        fawi_chevron_circle_down('\uf13a'),
        fawi_html5('\uf13b'),
        fawi_css3('\uf13c'),
        fawi_anchor('\uf13d'),
        fawi_unlock_alt('\uf13e'),
        fawi_bullseye('\uf140'),
        fawi_ellipsis_h('\uf141'),
        fawi_ellipsis_v('\uf142'),
        fawi_rss_square('\uf143'),
        fawi_play_circle('\uf144'),
        fawi_ticket('\uf145'),
        fawi_minus_square('\uf146'),
        fawi_minus_square_o('\uf147'),
        fawi_level_up('\uf148'),
        fawi_level_down('\uf149'),
        fawi_check_square('\uf14a'),
        fawi_pencil_square('\uf14b'),
        fawi_external_link_square('\uf14c'),
        fawi_share_square('\uf14d'),
        fawi_compass('\uf14e'),
        fawi_caret_square_o_down('\uf150'),
        fawi_caret_square_o_up('\uf151'),
        fawi_caret_square_o_right('\uf152'),
        fawi_eur('\uf153'),
        fawi_gbp('\uf154'),
        fawi_usd('\uf155'),
        fawi_inr('\uf156'),
        fawi_jpy('\uf157'),
        fawi_rub('\uf158'),
        fawi_krw('\uf159'),
        fawi_btc('\uf15a'),
        fawi_file('\uf15b'),
        fawi_file_text('\uf15c'),
        fawi_sort_alpha_asc('\uf15d'),
        fawi_sort_alpha_desc('\uf15e'),
        fawi_sort_amount_asc('\uf160'),
        fawi_sort_amount_desc('\uf161'),
        fawi_sort_numeric_asc('\uf162'),
        fawi_sort_numeric_desc('\uf163'),
        fawi_thumbs_up('\uf164'),
        fawi_thumbs_down('\uf165'),
        fawi_youtube_square('\uf166'),
        fawi_youtube('\uf167'),
        fawi_xing('\uf168'),
        fawi_xing_square('\uf169'),
        fawi_youtube_play('\uf16a'),
        fawi_dropbox('\uf16b'),
        fawi_stack_overflow('\uf16c'),
        fawi_instagram('\uf16d'),
        fawi_flickr('\uf16e'),
        fawi_adn('\uf170'),
        fawi_bitbucket('\uf171'),
        fawi_bitbucket_square('\uf172'),
        fawi_tumblr('\uf173'),
        fawi_tumblr_square('\uf174'),
        fawi_long_arrow_down('\uf175'),
        fawi_long_arrow_up('\uf176'),
        fawi_long_arrow_left('\uf177'),
        fawi_long_arrow_right('\uf178'),
        fawi_apple('\uf179'),
        fawi_windows('\uf17a'),
        fawi_android('\uf17b'),
        fawi_linux('\uf17c'),
        fawi_dribbble('\uf17d'),
        fawi_skype('\uf17e'),
        fawi_foursquare('\uf180'),
        fawi_trello('\uf181'),
        fawi_female('\uf182'),
        fawi_male('\uf183'),
        fawi_gratipay('\uf184'),
        fawi_sun_o('\uf185'),
        fawi_moon_o('\uf186'),
        fawi_archive('\uf187'),
        fawi_bug('\uf188'),
        fawi_vk('\uf189'),
        fawi_weibo('\uf18a'),
        fawi_renren('\uf18b'),
        fawi_pagelines('\uf18c'),
        fawi_stack_exchange('\uf18d'),
        fawi_arrow_circle_o_right('\uf18e'),
        fawi_arrow_circle_o_left('\uf190'),
        fawi_caret_square_o_left('\uf191'),
        fawi_dot_circle_o('\uf192'),
        fawi_wheelchair('\uf193'),
        fawi_vimeo_square('\uf194'),
        fawi_try('\uf195'),
        fawi_plus_square_o('\uf196'),
        fawi_space_shuttle('\uf197'),
        fawi_slack('\uf198'),
        fawi_envelope_square('\uf199'),
        fawi_wordpress('\uf19a'),
        fawi_openid('\uf19b'),
        fawi_university('\uf19c'),
        fawi_graduation_cap('\uf19d'),
        fawi_yahoo('\uf19e'),
        fawi_google('\uf1a0'),
        fawi_reddit('\uf1a1'),
        fawi_reddit_square('\uf1a2'),
        fawi_stumbleupon_circle('\uf1a3'),
        fawi_stumbleupon('\uf1a4'),
        fawi_delicious('\uf1a5'),
        fawi_digg('\uf1a6'),
        fawi_pied_piper_pp('\uf1a7'),
        fawi_pied_piper_alt('\uf1a8'),
        fawi_drupal('\uf1a9'),
        fawi_joomla('\uf1aa'),
        fawi_language('\uf1ab'),
        fawi_fax('\uf1ac'),
        fawi_building('\uf1ad'),
        fawi_child('\uf1ae'),
        fawi_paw('\uf1b0'),
        fawi_spoon('\uf1b1'),
        fawi_cube('\uf1b2'),
        fawi_cubes('\uf1b3'),
        fawi_behance('\uf1b4'),
        fawi_behance_square('\uf1b5'),
        fawi_steam('\uf1b6'),
        fawi_steam_square('\uf1b7'),
        fawi_recycle('\uf1b8'),
        fawi_car('\uf1b9'),
        fawi_taxi('\uf1ba'),
        fawi_tree('\uf1bb'),
        fawi_spotify('\uf1bc'),
        fawi_deviantart('\uf1bd'),
        fawi_soundcloud('\uf1be'),
        fawi_database('\uf1c0'),
        fawi_file_pdf_o('\uf1c1'),
        fawi_file_word_o('\uf1c2'),
        fawi_file_excel_o('\uf1c3'),
        fawi_file_powerpoint_o('\uf1c4'),
        fawi_file_image_o('\uf1c5'),
        fawi_file_archive_o('\uf1c6'),
        fawi_file_audio_o('\uf1c7'),
        fawi_file_video_o('\uf1c8'),
        fawi_file_code_o('\uf1c9'),
        fawi_vine('\uf1ca'),
        fawi_codepen('\uf1cb'),
        fawi_jsfiddle('\uf1cc'),
        fawi_life_ring('\uf1cd'),
        fawi_circle_o_notch('\uf1ce'),
        fawi_rebel('\uf1d0'),
        fawi_empire('\uf1d1'),
        fawi_git_square('\uf1d2'),
        fawi_git('\uf1d3'),
        fawi_hacker_news('\uf1d4'),
        fawi_tencenti_weibo('\uf1d5'),
        fawi_qq('\uf1d6'),
        fawi_weixin('\uf1d7'),
        fawi_paper_plane('\uf1d8'),
        fawi_paper_plane_o('\uf1d9'),
        fawi_history('\uf1da'),
        fawi_circle_thin('\uf1db'),
        fawi_header('\uf1dc'),
        fawi_paragraph('\uf1dd'),
        fawi_sliders('\uf1de'),
        fawi_share_alt('\uf1e0'),
        fawi_share_alt_square('\uf1e1'),
        fawi_bomb('\uf1e2'),
        fawi_futbol_o('\uf1e3'),
        fawi_tty('\uf1e4'),
        fawi_binoculars('\uf1e5'),
        fawi_plug('\uf1e6'),
        fawi_slideshare('\uf1e7'),
        fawi_twitch('\uf1e8'),
        fawi_yelp('\uf1e9'),
        fawi_newspaper_o('\uf1ea'),
        fawi_wifi('\uf1eb'),
        fawi_calculator('\uf1ec'),
        fawi_paypal('\uf1ed'),
        fawi_google_wallet('\uf1ee'),
        fawi_cc_visa('\uf1f0'),
        fawi_cc_mastercard('\uf1f1'),
        fawi_cc_discover('\uf1f2'),
        fawi_cc_amex('\uf1f3'),
        fawi_cc_paypal('\uf1f4'),
        fawi_cc_stripe('\uf1f5'),
        fawi_bell_slash('\uf1f6'),
        fawi_bell_slash_o('\uf1f7'),
        fawi_trash('\uf1f8'),
        fawi_copyright('\uf1f9'),
        fawi_at('\uf1fa'),
        fawi_eyedropper('\uf1fb'),
        fawi_paint_brush('\uf1fc'),
        fawi_birthday_cake('\uf1fd'),
        fawi_area_chart('\uf1fe'),
        fawi_pie_chart('\uf200'),
        fawi_line_chart('\uf201'),
        fawi_lastfm('\uf202'),
        fawi_lastfm_square('\uf203'),
        fawi_toggle_off('\uf204'),
        fawi_toggle_on('\uf205'),
        fawi_bicycle('\uf206'),
        fawi_bus('\uf207'),
        fawi_ioxhost('\uf208'),
        fawi_angellist('\uf209'),
        fawi_cc('\uf20a'),
        fawi_ils('\uf20b'),
        fawi_meanpath('\uf20c'),
        fawi_buysellads('\uf20d'),
        fawi_connectdevelop('\uf20e'),
        fawi_dashcube('\uf210'),
        fawi_forumbee('\uf211'),
        fawi_leanpub('\uf212'),
        fawi_sellsy('\uf213'),
        fawi_shirtsinbulk('\uf214'),
        fawi_simplybuilt('\uf215'),
        fawi_skyatlas('\uf216'),
        fawi_cart_plus('\uf217'),
        fawi_cart_arrow_down('\uf218'),
        fawi_diamond('\uf219'),
        fawi_ship('\uf21a'),
        fawi_user_secret('\uf21b'),
        fawi_motorcycle('\uf21c'),
        fawi_street_view('\uf21d'),
        fawi_heartbeat('\uf21e'),
        fawi_venus('\uf221'),
        fawi_mars('\uf222'),
        fawi_mercury('\uf223'),
        fawi_transgender('\uf224'),
        fawi_transgender_alt('\uf225'),
        fawi_venus_double('\uf226'),
        fawi_mars_double('\uf227'),
        fawi_venus_mars('\uf228'),
        fawi_mars_stroke('\uf229'),
        fawi_mars_stroke_v('\uf22a'),
        fawi_mars_stroke_h('\uf22b'),
        fawi_neuter('\uf22c'),
        fawi_genderless('\uf22d'),
        fawi_facebook_official('\uf230'),
        fawi_pinterest_p('\uf231'),
        fawi_whatsapp('\uf232'),
        fawi_server('\uf233'),
        fawi_user_plus('\uf234'),
        fawi_user_times('\uf235'),
        fawi_bed('\uf236'),
        fawi_viacoin('\uf237'),
        fawi_train('\uf238'),
        fawi_subway('\uf239'),
        fawi_medium('\uf23a'),
        fawi_y_combinator('\uf23b'),
        fawi_optin_monster('\uf23c'),
        fawi_opencart('\uf23d'),
        fawi_expeditedssl('\uf23e'),
        fawi_battery_full('\uf240'),
        fawi_battery_three_quarters('\uf241'),
        fawi_battery_half('\uf242'),
        fawi_battery_quarter('\uf243'),
        fawi_battery_empty('\uf244'),
        fawi_mouse_pointer('\uf245'),
        fawi_i_cursor('\uf246'),
        fawi_object_group('\uf247'),
        fawi_object_ungroup('\uf248'),
        fawi_sticky_note('\uf249'),
        fawi_sticky_note_o('\uf24a'),
        fawi_cc_jcb('\uf24b'),
        fawi_cc_diners_club('\uf24c'),
        fawi_clone('\uf24d'),
        fawi_balance_scale('\uf24e'),
        fawi_hourglass_o('\uf250'),
        fawi_hourglass_start('\uf251'),
        fawi_hourglass_half('\uf252'),
        fawi_hourglass_end('\uf253'),
        fawi_hourglass('\uf254'),
        fawi_hand_rock_o('\uf255'),
        fawi_hand_paper_o('\uf256'),
        fawi_hand_scissors_o('\uf257'),
        fawi_hand_lizard_o('\uf258'),
        fawi_hand_spock_o('\uf259'),
        fawi_hand_pointer_o('\uf25a'),
        fawi_hand_peace_o('\uf25b'),
        fawi_trademark('\uf25c'),
        fawi_registered('\uf25d'),
        fawi_creative_commons('\uf25e'),
        fawi_gg('\uf260'),
        fawi_gg_circle('\uf261'),
        fawi_tripadvisor('\uf262'),
        fawi_odnoklassniki('\uf263'),
        fawi_odnoklassniki_square('\uf264'),
        fawi_get_pocket('\uf265'),
        fawi_wikipedia_w('\uf266'),
        fawi_safari('\uf267'),
        fawi_chrome('\uf268'),
        fawi_firefox('\uf269'),
        fawi_opera('\uf26a'),
        fawi_internet_explorer('\uf26b'),
        fawi_television('\uf26c'),
        fawi_contao('\uf26d'),
        fawi_500px('\uf26e'),
        fawi_amazon('\uf270'),
        fawi_calendar_plus_o('\uf271'),
        fawi_calendar_minus_o('\uf272'),
        fawi_calendar_times_o('\uf273'),
        fawi_calendar_check_o('\uf274'),
        fawi_industry('\uf275'),
        fawi_map_pin('\uf276'),
        fawi_map_signs('\uf277'),
        fawi_map_o('\uf278'),
        fawi_map('\uf279'),
        fawi_commenting('\uf27a'),
        fawi_commenting_o('\uf27b'),
        fawi_houzz('\uf27c'),
        fawi_vimeo('\uf27d'),
        fawi_black_tie('\uf27e'),
        fawi_fonticons('\uf280'),
        fawi_reddit_alien('\uf281'),
        fawi_edge('\uf282'),
        fawi_credit_card_alt('\uf283'),
        fawi_codiepie('\uf284'),
        fawi_modx('\uf285'),
        fawi_fort_awesome('\uf286'),
        fawi_usb('\uf287'),
        fawi_product_hunt('\uf288'),
        fawi_mixcloud('\uf289'),
        fawi_scribd('\uf28a'),
        fawi_pause_circle('\uf28b'),
        fawi_pause_circle_o('\uf28c'),
        fawi_stop_circle('\uf28d'),
        fawi_stop_circle_o('\uf28e'),
        fawi_shopping_bag('\uf290'),
        fawi_shopping_basket('\uf291'),
        fawi_hashtag('\uf292'),
        fawi_bluetooth('\uf293'),
        fawi_bluetooth_b('\uf294'),
        fawi_percent('\uf295'),
        fawi_gitlab('\uf296'),
        fawi_wpbeginner('\uf297'),
        fawi_wpforms('\uf298'),
        fawi_envira('\uf299'),
        fawi_universal_access('\uf29a'),
        fawi_wheelchair_alt('\uf29b'),
        fawi_question_circle_o('\uf29c'),
        fawi_blind('\uf29d'),
        fawi_audio_description('\uf29e'),
        fawi_volume_control_phone('\uf2a0'),
        fawi_braille('\uf2a1'),
        fawi_assistive_listening_systems('\uf2a2'),
        fawi_american_sign_language_interpreting('\uf2a3'),
        fawi_deaf('\uf2a4'),
        fawi_glide('\uf2a5'),
        fawi_glide_g('\uf2a6'),
        fawi_sign_language('\uf2a7'),
        fawi_low_vision('\uf2a8'),
        fawi_viadeo('\uf2a9'),
        fawi_viadeo_square('\uf2aa'),
        fawi_snapchat('\uf2ab'),
        fawi_snapchat_ghost('\uf2ac'),
        fawi_snapchat_square('\uf2ad'),
        fawi_pied_piper('\uf2ae'),
        fawi_first_order('\uf2b0'),
        fawi_yoast('\uf2b1'),
        fawi_themeisle('\uf2b2'),
        fawi_google_plus_official('\uf2b3'),
        fawi_font_awesome('\uf2b4'),
        fawi_handshake_o('\uf2b5'),
        fawi_envelope_open('\uf2b6'),
        fawi_envelope_open_o('\uf2b7'),
        fawi_linode('\uf2b8'),
        fawi_address_book('\uf2b9'),
        fawi_address_book_o('\uf2ba'),
        fawi_address_card('\uf2bb'),
        fawi_address_card_o('\uf2bc'),
        fawi_user_circle('\uf2bd'),
        fawi_user_circle_o('\uf2be'),
        fawi_user_o('\uf2c0'),
        fawi_id_badge('\uf2c1'),
        fawi_id_card('\uf2c2'),
        fawi_id_card_o('\uf2c3'),
        fawi_quora('\uf2c4'),
        fawi_free_code_camp('\uf2c5'),
        fawi_telegram('\uf2c6'),
        fawi_thermometer_full('\uf2c7'),
        fawi_thermometer_three_quarters('\uf2c8'),
        fawi_thermometer_half('\uf2c9'),
        fawi_thermometer_quarter('\uf2ca'),
        fawi_thermometer_empty('\uf2cb'),
        fawi_shower('\uf2cc'),
        fawi_bath('\uf2cd'),
        fawi_podcast('\uf2ce'),
        fawi_window_maximize('\uf2d0'),
        fawi_window_minimize('\uf2d1'),
        fawi_window_restore('\uf2d2'),
        fawi_window_close('\uf2d3'),
        fawi_window_close_o('\uf2d4'),
        fawi_bandcamp('\uf2d5'),
        fawi_grav('\uf2d6'),
        fawi_etsy('\uf2d7'),
        fawi_imdb('\uf2d8'),
        fawi_ravelry('\uf2d9'),
        fawi_eercast('\uf2da'),
        fawi_microchip('\uf2db'),
        fawi_snowflake_o('\uf2dc'),
        fawi_superpowers('\uf2dd'),
        fawi_wpexplorer('\uf2de'),
        fawi_meetup('\uf2e0');


        char character;

        Icon(char character) {
            this.character = character;
        }

        public String getFormattedName() {
            return "{" + name() + "}";
        }

        public char getCharacter() {
            return character;
        }

        public String getName() {
            return name();
        }

        // remember the typeface so we can use it later
        private static ITypeface typeface;

        public ITypeface getTypeface() {
            if (typeface == null) {
                typeface = new FontAwesome();
            }
            return typeface;
        }
    }
}

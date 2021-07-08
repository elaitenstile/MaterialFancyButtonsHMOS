package com.rilixtech.vaadin_icons_typeface;

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

public class VaadinIcons implements ITypeface {
    private static final String TTF_FILE = "vaadin-icons-v4.1.0.ttf";
    private static final String MAPPING_FONT_PREFIX = "vaai";

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
        return "Vaadin Icons";
    }

    @Override public String getVersion() {
        return "4.1.0";
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
        return "Jarmo Kemppainen";
    }

    @Override public String getUrl() {
        return "https://vaadin.com/icons/";
    }

    @Override public String getDescription() {
        return "Vaadin Icons is a set of 600+ icons designed for web applications. Free to use, anywhere!";
    }

    @Override public String getLicense() {
        return "Creative Commons licenses: CC-BY license";
    }

    @Override public String getLicenseUrl() {
        return "https://creativecommons.org/licenses/by/4.0/";
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
        vaai_abacus('\ue682'),
        vaai_absolute_position('\ue61e'),
        vaai_accessibility('\ue683'),
        vaai_accordion_menu('\ue61f'),
        vaai_add_dock('\ue620'),
        vaai_adjust('\ue74a'),
        vaai_airplane('\ue684'),
        vaai_align_center('\ue74b'),
        vaai_align_justify('\ue7ae'),
        vaai_align_left('\ue74c'),
        vaai_align_right('\ue74d'),
        vaai_anchor('\ue685'),
        vaai_angle_double_down('\ue6e6'),
        vaai_angle_double_left('\ue6e7'),
        vaai_angle_double_right('\ue6e8'),
        vaai_angle_double_up('\ue6e9'),
        vaai_angle_down('\ue6ea'),
        vaai_angle_left('\ue6eb'),
        vaai_angle_right('\ue6ec'),
        vaai_angle_up('\ue6ed'),
        vaai_archive('\ue6ee'),
        vaai_archives('\ue621'),
        vaai_area_select('\ue806'),
        vaai_arrow_backward('\ue622'),
        vaai_arrow_circle_down('\ue6f0'),
        vaai_arrow_circle_down_o('\ue6ef'),
        vaai_arrow_circle_left('\ue6f2'),
        vaai_arrow_circle_left_o('\ue6f1'),
        vaai_arrow_circle_right('\ue6f4'),
        vaai_arrow_circle_right_o('\ue6f3'),
        vaai_arrow_circle_up('\ue6f6'),
        vaai_arrow_circle_up_o('\ue6f5'),
        vaai_arrow_down('\ue7af'),
        vaai_arrow_forward('\ue623'),
        vaai_arrow_left('\ue7b0'),
        vaai_arrow_long_down('\ue74e'),
        vaai_arrow_long_left('\ue74f'),
        vaai_arrow_right('\ue7b1'),
        vaai_arrow_up('\ue7b2'),
        vaai_arrows('\ue755'),
        vaai_arrows_cross('\ue750'),
        vaai_arrows_long_h('\ue751'),
        vaai_arrows_long_right('\ue752'),
        vaai_arrows_long_up('\ue753'),
        vaai_arrows_long_v('\ue754'),
        vaai_asterisk('\ue686'),
        vaai_at('\ue624'),
        vaai_automation('\ue687'),
        vaai_backwards('\ue756'),
        vaai_ban('\ue6f7'),
        vaai_bar_chart('\ue757'),
        vaai_barcode('\ue688'),
        vaai_menu('\ue7b3'),
        vaai_bell('\ue7b4'),
        vaai_bell_o('\ue758'),
        vaai_bell_slash('\ue626'),
        vaai_bell_slash_o('\ue625'),
        vaai_boat('\ue627'),
        vaai_bold('\ue6f8'),
        vaai_bolt('\ue759'),
        vaai_bomb('\ue689'),
        vaai_book('\ue6f9'),
        vaai_book_dollar('\ue600'),
        vaai_book_percent('\ue601'),
        vaai_bookmark('\ue7b6'),
        vaai_bookmark_o('\ue7b5'),
        vaai_briefcase('\ue602'),
        vaai_browser('\ue628'),
        vaai_bug('\ue68b'),
        vaai_bug_o('\ue68a'),
        vaai_building('\ue7b8'),
        vaai_building_o('\ue7b7'),
        vaai_bullets('\ue629'),
        vaai_bullseye('\ue6fa'),
        vaai_button('\ue62a'),
        vaai_calc('\ue68c'),
        vaai_calc_book('\ue62b'),
        vaai_calendar('\ue7ba'),
        vaai_calendar_briefcase('\ue604'),
        vaai_calendar_clock('\ue605'),
        vaai_calendar_envelope('\ue62c'),
        vaai_calendar_o('\ue7b9'),
        vaai_calendar_user('\ue606'),
        vaai_camera('\ue7bb'),
        vaai_car('\ue62d'),
        vaai_caret_down('\ue7bc'),
        vaai_caret_left('\ue7bd'),
        vaai_caret_right('\ue7be'),
        vaai_caret_square_down_o('\ue7bf'),
        vaai_caret_square_left_o('\ue7c0'),
        vaai_caret_square_right_o('\ue7c1'),
        vaai_caret_square_up_o('\ue7c2'),
        vaai_caret_up('\ue7c3'),
        vaai_cart('\ue6fc'),
        vaai_cart_o('\ue6fb'),
        vaai_chart('\ue68e'),
        vaai_chart_line('\ue68d'),
        vaai_chat('\ue75a'),
        vaai_check('\ue75b'),
        vaai_check_circle('\ue7c5'),
        vaai_check_circle_o('\ue7c4'),
        vaai_check_square('\ue62e'),
        vaai_check_square_o('\ue6fd'),
        vaai_chevron_circle_down('\ue7c7'),
        vaai_chevron_circle_down_o('\ue7c6'),
        vaai_chevron_circle_left('\ue7c9'),
        vaai_chevron_circle_left_o('\ue7c8'),
        vaai_chevron_circle_right('\ue7cb'),
        vaai_chevron_circle_right_o('\ue7ca'),
        vaai_chevron_circle_up('\ue7cd'),
        vaai_chevron_circle_up_o('\ue7cc'),
        vaai_chevron_down('\ue7ce'),
        vaai_chevron_left('\ue7cf'),
        vaai_chevron_right('\ue7d0'),
        vaai_chevron_up('\ue7d1'),
        vaai_child('\ue62f'),
        vaai_circle('\ue75d'),
        vaai_circle_thin('\ue75c'),
        vaai_clipboard('\ue635'),
        vaai_clipboard_cross('\ue630'),
        vaai_clipboard_heart('\ue631'),
        vaai_clipboard_pulse('\ue632'),
        vaai_clipboard_text('\ue633'),
        vaai_clipboard_user('\ue634'),
        vaai_clock('\ue7d2'),
        vaai_cloud('\ue763'),
        vaai_cloud_download('\ue75f'),
        vaai_cloud_download_o('\ue75e'),
        vaai_cloud_o('\ue760'),
        vaai_cloud_upload('\ue762'),
        vaai_cloud_upload_o('\ue761'),
        vaai_code('\ue68f'),
        vaai_coffee('\ue690'),
        vaai_cog('\ue7d3'),
        vaai_cog_o('\ue764'),
        vaai_cogs('\ue691'),
        vaai_combobox('\ue636'),
        vaai_comment('\ue768'),
        vaai_comment_ellipsis('\ue766'),
        vaai_comment_ellipsis_o('\ue765'),
        vaai_comment_o('\ue767'),
        vaai_comments('\ue76a'),
        vaai_comments_o('\ue769'),
        vaai_compress('\ue76b'),
        vaai_compress_square('\ue637'),
        vaai_connect('\ue76d'),
        vaai_connect_o('\ue76c'),
        vaai_controller('\ue692'),
        vaai_copy('\ue7d5'),
        vaai_copy_o('\ue7d4'),
        vaai_copyright('\ue638'),
        vaai_corner_lower_left('\ue693'),
        vaai_corner_lower_right('\ue694'),
        vaai_corner_upper_left('\ue695'),
        vaai_corner_upper_right('\ue696'),
        vaai_credit_card('\ue76e'),
        vaai_crop('\ue76f'),
        vaai_cross_cutlery('\ue6fe'),
        vaai_crosshairs('\ue7d6'),
        vaai_css('\ue639'),
        vaai_cube('\ue697'),
        vaai_cubes('\ue698'),
        vaai_curly_brackets('\ue63a'),
        vaai_cutlery('\ue6ff'),
        vaai_dashboard('\ue700'),
        vaai_date_input('\ue63b'),
        vaai_deindent('\ue770'),
        vaai_dental_chair('\ue607'),
        vaai_desktop('\ue7d7'),
        vaai_disc('\ue701'),
        vaai_doctor('\ue609'),
        vaai_doctor_briefcase('\ue608'),
        vaai_dollar('\ue60a'),
        vaai_dot_circle('\ue702'),
        vaai_download('\ue703'),
        vaai_download_alt('\ue699'),
        vaai_insert('\ue7d8'),
        vaai_drop('\ue704'),
        vaai_edit('\ue771'),
        vaai_eject('\ue772'),
        vaai_elastic('\ue63c'),
        vaai_ellipsis_circle('\ue7da'),
        vaai_ellipsis_circle_o('\ue7d9'),
        vaai_ellipsis_h('\ue773'),
        vaai_ellipsis_v('\ue774'),
        vaai_envelope('\ue7dc'),
        vaai_envelope_o('\ue7db'),
        vaai_envelope_open('\ue63e'),
        vaai_envelope_open_o('\ue63d'),
        vaai_eraser('\ue69a'),
        vaai_exchange('\ue705'),
        vaai_exclamation('\ue708'),
        vaai_exclamation_circle('\ue707'),
        vaai_exclamation_circle_o('\ue706'),
        vaai_exit('\ue60c'),
        vaai_exit_o('\ue60b'),
        vaai_expand('\ue776'),
        vaai_expand_full('\ue775'),
        vaai_expand_square('\ue7dd'),
        vaai_external_browser('\ue63f'),
        vaai_external_link('\ue7de'),
        vaai_eye('\ue7df'),
        vaai_eye_slash('\ue709'),
        vaai_eyedropper('\ue640'),
        vaai_facebook('\ue69c'),
        vaai_facebook_square('\ue69b'),
        vaai_factory('\ue641'),
        vaai_fast_backward('\ue777'),
        vaai_fast_forward('\ue778'),
        vaai_female('\ue69d'),
        vaai_file('\ue7e3'),
        vaai_file_code('\ue70a'),
        vaai_file_font('\ue69e'),
        vaai_file_movie('\ue70b'),
        vaai_file_o('\ue7e0'),
        vaai_file_picture('\ue70c'),
        vaai_file_presentation('\ue69f'),
        vaai_file_process('\ue642'),
        vaai_file_refresh('\ue643'),
        vaai_file_sound('\ue70d'),
        vaai_file_start('\ue644'),
        vaai_file_table('\ue6a0'),
        vaai_file_text('\ue7e2'),
        vaai_file_text_o('\ue7e1'),
        vaai_file_tree('\ue647'),
        vaai_file_tree_small('\ue645'),
        vaai_file_tree_sub('\ue646'),
        vaai_file_zip('\ue70e'),
        vaai_fill('\ue6a1'),
        vaai_film('\ue779'),
        vaai_filter('\ue6a2'),
        vaai_fire('\ue6a3'),
        vaai_flag('\ue711'),
        vaai_flag_checkered('\ue70f'),
        vaai_flag_o('\ue710'),
        vaai_adobe_flash('\ue648'),
        vaai_flash('\ue712'),
        vaai_flask('\ue7e4'),
        vaai_flip_h('\ue649'),
        vaai_flip_v('\ue64a'),
        vaai_folder('\ue7e6'),
        vaai_folder_o('\ue7e5'),
        vaai_folder_open('\ue77b'),
        vaai_folder_open_o('\ue77a'),
        vaai_font('\ue713'),
        vaai_form('\ue64b'),
        vaai_forward('\ue77c'),
        vaai_frown_o('\ue6a4'),
        vaai_funcion('\ue64c'),
        vaai_gamepad('\ue714'),
        vaai_gavel('\ue6a5'),
        vaai_gift('\ue715'),
        vaai_glass('\ue77d'),
        vaai_globe('\ue77e'),
        vaai_glasses('\ue7e7'),
        vaai_golf('\ue60d'),
        vaai_google_plus('\ue6a7'),
        vaai_google_plus_square('\ue6a6'),
        vaai_grab('\ue64d'),
        vaai_grid('\ue651'),
        vaai_grid_bevel('\ue64e'),
        vaai_grid_big('\ue7e9'),
        vaai_grid_big_o('\ue7e8'),
        vaai_grid_h('\ue64f'),
        vaai_grid_small('\ue7eb'),
        vaai_grid_small_o('\ue7ea'),
        vaai_grid_v('\ue650'),
        vaai_group('\ue60e'),
        vaai_hand('\ue652'),
        vaai_handle_corner('\ue716'),
        vaai_hands_up('\ue6a8'),
        vaai_harddrive('\ue718'),
        vaai_harddrive_o('\ue717'),
        vaai_hash('\ue6a9'),
        vaai_header('\ue719'),
        vaai_headphones('\ue71a'),
        vaai_health_card('\ue60f'),
        vaai_heart('\ue780'),
        vaai_heart_o('\ue77f'),
        vaai_home('\ue7ed'),
        vaai_home_o('\ue7ec'),
        vaai_inbox('\ue71b'),
        vaai_indent('\ue781'),
        vaai_info('\ue71e'),
        vaai_info_circle('\ue71d'),
        vaai_info_circle_o('\ue71c'),
        vaai_input('\ue653'),
        vaai_institution('\ue6aa'),
        vaai_invoice('\ue610'),
        vaai_list_ol('\ue71f'),
        vaai_italic('\ue720'),
        vaai_key('\ue6ac'),
        vaai_key_o('\ue6ab'),
        vaai_keyboard('\ue722'),
        vaai_keyboard_o('\ue721'),
        vaai_laptop('\ue782'),
        vaai_layout('\ue654'),
        vaai_level_down('\ue783'),
        vaai_level_down_bold('\ue611'),
        vaai_level_left('\ue784'),
        vaai_level_left_bold('\ue612'),
        vaai_level_right('\ue785'),
        vaai_level_right_bold('\ue655'),
        vaai_level_up('\ue786'),
        vaai_level_up_bold('\ue613'),
        vaai_lifebuoy('\ue6ad'),
        vaai_lightbulb('\ue6ae'),
        vaai_line_h('\ue723'),
        vaai_line_v('\ue724'),
        vaai_lines('\ue7ef'),
        vaai_lines_list('\ue7ee'),
        vaai_link('\ue725'),
        vaai_list('\ue7f1'),
        vaai_list_select('\ue656'),
        vaai_list_ul('\ue7f0'),
        vaai_location_arrow('\ue728'),
        vaai_location_arrow_circle('\ue727'),
        vaai_location_arrow_circle_o('\ue726'),
        vaai_lock('\ue7f2'),
        vaai_magic('\ue6b1'),
        vaai_magnet('\ue787'),
        vaai_mailbox('\ue729'),
        vaai_male('\ue6b2'),
        vaai_map_marker('\ue788'),
        vaai_margin('\ue65b'),
        vaai_margin_bottom('\ue657'),
        vaai_margin_left('\ue658'),
        vaai_margin_right('\ue659'),
        vaai_margin_top('\ue65a'),
        vaai_medal('\ue6b3'),
        vaai_megafone('\ue6b4'),
        vaai_meh_o('\ue6b5'),
        vaai_microphone('\ue72a'),
        vaai_minus('\ue7f6'),
        vaai_minus_circle('\ue7f4'),
        vaai_minus_circle_o('\ue7f3'),
        vaai_minus_square_o('\ue7f5'),
        vaai_mobile('\ue7f7'),
        vaai_modal('\ue7f8'),
        vaai_modal_list('\ue72b'),
        vaai_money('\ue6b6'),
        vaai_moon('\ue78a'),
        vaai_moon_o('\ue789'),
        vaai_movie('\ue78b'),
        vaai_music('\ue78c'),
        vaai_mute('\ue72c'),
        vaai_native_button('\ue65c'),
        vaai_notebook('\ue65d'),
        vaai_open_book('\ue7f9'),
        vaai_options('\ue65e'),
        vaai_orientation('\ue65f'),
        vaai_out('\ue614'),
        vaai_outbox('\ue660'),
        vaai_package('\ue6b7'),
        vaai_padding('\ue665'),
        vaai_padding_bottom('\ue661'),
        vaai_padding_left('\ue662'),
        vaai_padding_right('\ue663'),
        vaai_padding_top('\ue664'),
        vaai_paint_roll('\ue666'),
        vaai_paintbrush('\ue6b8'),
        vaai_palete('\ue667'),
        vaai_panel('\ue668'),
        vaai_paperclip('\ue72d'),
        vaai_paperplane('\ue6b9'),
        vaai_paperplane_o('\ue6ba'),
        vaai_paragraph('\ue6bb'),
        vaai_password('\ue669'),
        vaai_paste('\ue6bc'),
        vaai_pause('\ue78d'),
        vaai_pencil('\ue7fa'),
        vaai_phone('\ue7fb'),
        vaai_picture('\ue7fc'),
        vaai_pie_chart('\ue6bd'),
        vaai_pill('\ue615'),
        vaai_pills('\ue616'),
        vaai_pin('\ue7fd'),
        vaai_pin_post('\ue6be'),
        vaai_play('\ue78e'),
        vaai_play_circle('\ue731'),
        vaai_play_circle_o('\ue72e'),
        vaai_plug('\ue66a'),
        vaai_plus('\ue801'),
        vaai_plus_circle('\ue7ff'),
        vaai_plus_circle_o('\ue7fe'),
        vaai_plus_minus('\ue603'),
        vaai_plus_square_o('\ue800'),
        vaai_pointer('\ue66b'),
        vaai_power_off('\ue78f'),
        vaai_presentation('\ue6bf'),
        vaai_print('\ue802'),
        vaai_progressbar('\ue66c'),
        vaai_puzzle_piece('\ue6c0'),
        vaai_qrcode('\ue6c1'),
        vaai_question('\ue732'),
        vaai_question_circle('\ue730'),
        vaai_question_circle_o('\ue72f'),
        vaai_quote_left('\ue6c2'),
        vaai_quote_right('\ue6c3'),
        vaai_random('\ue733'),
        vaai_raster('\ue6c5'),
        vaai_raster_lower_left('\ue6c4'),
        vaai_recycle('\ue6c6'),
        vaai_refresh('\ue790'),
        vaai_reply('\ue792'),
        vaai_reply_all('\ue791'),
        vaai_resize_h('\ue66d'),
        vaai_resize_v('\ue66e'),
        vaai_retweet('\ue793'),
        vaai_rhombus('\ue66f'),
        vaai_road('\ue6c7'),
        vaai_road_branch('\ue670'),
        vaai_road_branches('\ue671'),
        vaai_road_split('\ue672'),
        vaai_rocket('\ue6c8'),
        vaai_rotate_left('\ue794'),
        vaai_rotate_right('\ue795'),
        vaai_rss('\ue6ca'),
        vaai_rss_square('\ue6c9'),
        vaai_safe('\ue6cc'),
        vaai_safe_lock('\ue6cb'),
        vaai_scissors('\ue734'),
        vaai_screwdriver('\ue735'),
        vaai_search('\ue805'),
        vaai_search_minus('\ue803'),
        vaai_search_plus('\ue804'),
        vaai_select('\ue673'),
        vaai_database('\ue737'),
        vaai_server('\ue736'),
        vaai_share('\ue796'),
        vaai_share_square('\ue6cd'),
        vaai_shield('\ue6ce'),
        vaai_sign_in('\ue797'),
        vaai_sign_in_alt('\ue6b0'),
        vaai_sign_out('\ue798'),
        vaai_sign_out_alt('\ue6af'),
        vaai_signal('\ue738'),
        vaai_sitemap('\ue739'),
        vaai_slider('\ue674'),
        vaai_sliders('\ue6cf'),
        vaai_smiley_o('\ue6d0'),
        vaai_sort('\ue799'),
        vaai_sound_disable('\ue79a'),
        vaai_specialist('\ue617'),
        vaai_spinner('\ue6d3'),
        vaai_spinner_arc('\ue6d1'),
        vaai_spinner_third('\ue6d2'),
        vaai_split('\ue675'),
        vaai_split_h('\ue807'),
        vaai_split_v('\ue808'),
        vaai_spoon('\ue73a'),
        vaai_square_shadow('\ue79b'),
        vaai_star('\ue7a1'),
        vaai_star_half_left('\ue79d'),
        vaai_star_half_left_o('\ue79c'),
        vaai_star_half_right('\ue79f'),
        vaai_star_half_right_o('\ue79e'),
        vaai_star_o('\ue7a0'),
        vaai_start_cog('\ue676'),
        vaai_step_backward('\ue7a2'),
        vaai_step_forward('\ue7a3'),
        vaai_stethoscope('\ue618'),
        vaai_stop('\ue7a4'),
        vaai_stop_cog('\ue677'),
        vaai_strikethrough('\ue73b'),
        vaai_subscript('\ue6d4'),
        vaai_suitcase('\ue809'),
        vaai_sun_o('\ue73c'),
        vaai_superscript('\ue6d5'),
        vaai_sword('\ue678'),
        vaai_table('\ue7a5'),
        vaai_tablet('\ue80a'),
        vaai_tabs('\ue679'),
        vaai_tag('\ue6d6'),
        vaai_tags('\ue6d7'),
        vaai_tasks('\ue73d'),
        vaai_taxi('\ue67a'),
        vaai_terminal('\ue6d8'),
        vaai_text_height('\ue73e'),
        vaai_text_input('\ue67b'),
        vaai_text_label('\ue67c'),
        vaai_text_width('\ue73f'),
        vaai_teeth('\ue619'),
        vaai_thin_square('\ue7a6'),
        vaai_tooth('\ue67d'),
        vaai_thumbs_down('\ue6da'),
        vaai_thumbs_down_o('\ue6d9'),
        vaai_thumbs_up('\ue6dc'),
        vaai_thumbs_up_o('\ue6db'),
        vaai_ticket('\ue740'),
        vaai_time_backward('\ue7a7'),
        vaai_time_forward('\ue7a8'),
        vaai_toolbox('\ue741'),
        vaai_tools('\ue742'),
        vaai_train('\ue67e'),
        vaai_trash('\ue80b'),
        vaai_tree_table('\ue67f'),
        vaai_trophy('\ue743'),
        vaai_truck('\ue6dd'),
        vaai_twin_col_select('\ue680'),
        vaai_twitter('\ue6df'),
        vaai_twitter_square('\ue6de'),
        vaai_umbrella('\ue6e0'),
        vaai_underline('\ue744'),
        vaai_unlink('\ue745'),
        vaai_unlock('\ue80c'),
        vaai_upload('\ue746'),
        vaai_upload_alt('\ue6e1'),
        vaai_user('\ue80d'),
        vaai_user_card('\ue61a'),
        vaai_user_check('\ue61b'),
        vaai_user_clock('\ue61c'),
        vaai_user_heart('\ue61d'),
        vaai_users('\ue747'),
        vaai_vaadin_h('\ue80e'),
        vaai_vaadin_v('\ue80f'),
        vaai_viewport('\ue681'),
        vaai_vimeo('\ue6e3'),
        vaai_vimeo_square('\ue6e2'),
        vaai_volume('\ue7ac'),
        vaai_volume_down('\ue7a9'),
        vaai_volume_off('\ue7aa'),
        vaai_volume_up('\ue7ab'),
        vaai_warning('\ue748'),
        vaai_wrench('\ue749'),
        vaai_close('\ue7ad'),
        vaai_close_circle('\ue811'),
        vaai_close_circle_o('\ue810'),
        vaai_youtube('\ue6e5'),
        vaai_youtube_square('\ue6e4'),
        vaai_diploma('\ue964'),
        vaai_chevron_down_small('\ue965'),
        vaai_chevron_left_small('\ue966'),
        vaai_chevron_right_small('\ue967'),
        vaai_chevron_up_small('\ue968'),
        vaai_diploma_scroll('\ue969'),
        vaai_workplace('\ue900'),
        vaai_cash('\ue901'),
        vaai_academy_cap('\ue902'),
        vaai_alarm('\ue903'),
        vaai_alt_a('\ue904'),
        vaai_alt('\ue905'),
        vaai_ambulance('\ue906'),
        vaai_backspace_a('\ue907'),
        vaai_backspace('\ue908'),
        vaai_bar_chart_h('\ue909'),
        vaai_bar_chart_v('\ue90a'),
        vaai_bed('\ue90b'),
        vaai_buss('\ue90c'),
        vaai_chart_3d('\ue90d'),
        vaai_chart_grid('\ue90e'),
        vaai_chart_timeline('\ue90f'),
        vaai_clipboard_check('\ue910'),
        vaai_close_small('\ue911'),
        vaai_cluster('\ue912'),
        vaai_coin_piles('\ue913'),
        vaai_coins('\ue914'),
        vaai_compile('\ue915'),
        vaai_close_big('\ue916'),
        vaai_ctrl_a('\ue917'),
        vaai_ctrl('\ue918'),
        vaai_cursor_o('\ue919'),
        vaai_cursor('\ue91a'),
        vaai_del_a('\ue91b'),
        vaai_del('\ue91c'),
        vaai_diamond_o('\ue91d'),
        vaai_diamond('\ue91e'),
        vaai_ellipsis_dots_h('\ue91f'),
        vaai_ellipsis_dots_v('\ue920'),
        vaai_enter_arrow('\ue921'),
        vaai_enter('\ue922'),
        vaai_envelopes_o('\ue923'),
        vaai_envelopes('\ue924'),
        vaai_esc_a('\ue925'),
        vaai_esc('\ue926'),
        vaai_euro('\ue927'),
        vaai_family('\ue928'),
        vaai_file_add('\ue929'),
        vaai_file_remove('\ue92a'),
        vaai_file_search('\ue92b'),
        vaai_flight_landing('\ue92c'),
        vaai_flight_takeoff('\ue92d'),
        vaai_folder_add('\ue92e'),
        vaai_folder_remove('\ue92f'),
        vaai_folder_search('\ue930'),
        vaai_funnel('\ue931'),
        vaai_globe_wire('\ue932'),
        vaai_hammer('\ue933'),
        vaai_handshake('\ue934'),
        vaai_headset('\ue935'),
        vaai_hospital('\ue936'),
        vaai_hourglass_empty('\ue937'),
        vaai_hourglass_end('\ue938'),
        vaai_hourglass_start('\ue939'),
        vaai_hourglass('\ue93a'),
        vaai_line_bar_chart('\ue93b'),
        vaai_line_chart('\ue93c'),
        vaai_mobile_browser('\ue93d'),
        vaai_mobile_retro('\ue93e'),
        vaai_money_deposit('\ue93f'),
        vaai_money_exchange('\ue940'),
        vaai_money_withdraw('\ue941'),
        vaai_morning('\ue942'),
        vaai_newspaper('\ue943'),
        vaai_nurse('\ue944'),
        vaai_office('\ue945'),
        vaai_option_a('\ue946'),
        vaai_option('\ue947'),
        vaai_phone_landline('\ue948'),
        vaai_pie_bar_chart('\ue949'),
        vaai_piggy_bank_coin('\ue94a'),
        vaai_piggy_bank('\ue94b'),
        vaai_pyramid_chart('\ue94c'),
        vaai_records('\ue94d'),
        vaai_scale_unbalance('\ue94e'),
        vaai_scale('\ue94f'),
        vaai_scatter_chart('\ue950'),
        vaai_shift_arrow('\ue951'),
        vaai_shift('\ue952'),
        vaai_shop('\ue953'),
        vaai_spark_line('\ue954'),
        vaai_spline_area_chart('\ue955'),
        vaai_spline_chart('\ue956'),
        vaai_stock('\ue957'),
        vaai_stopwatch('\ue958'),
        vaai_storage('\ue959'),
        vaai_sun_down('\ue95a'),
        vaai_sun_rise('\ue95b'),
        vaai_tab_a('\ue95c'),
        vaai_tab('\ue95d'),
        vaai_timer('\ue95e'),
        vaai_touch('\ue95f'),
        vaai_trending_down('\ue960'),
        vaai_trending_up('\ue961'),
        vaai_user_star('\ue962'),
        vaai_wallet('\ue963');

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
                typeface = new VaadinIcons();
            }
            return typeface;
        }
    }
}

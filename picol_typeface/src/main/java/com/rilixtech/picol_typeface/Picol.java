package com.rilixtech.picol_typeface;

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

public class Picol implements ITypeface {
  private static final String TTF_FILE = "picol-v1.1.ttf";
  private static final String MAPPING_FONT_PREFIX = "pici";

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
    return "Picol Icon";
  }

  @Override public String getVersion() {
    return "1.1";
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
    return "http://picol.org/";
  }

  @Override public String getUrl() {
    return "http://picol.org/";
  }

  @Override public String getDescription() {
    return "PICOL stands for PIctorial COmmunication Language and is a project to find a standard and reduced sign system for electronic communication.";
  }

  @Override public String getLicense() {
    return "Creative Commons-License BY";
  }

  @Override public String getLicenseUrl() {
    return "http://www.creativecommons.org/licenses/by/3.0/";
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
    pici_accept('\ue800'),
    pici_zoom_out('\uea24'),
    pici_agent('\ue802'),
    pici_api('\ue803'),
    pici_apple('\ue804'),
    pici_application('\ue805'),
    pici_arrow_full_down('\ue806'),
    pici_arrow_full_left('\ue807'),
    pici_arrow_full_lowerleft('\ue808'),
    pici_arrow_full_lowerright('\ue809'),
    pici_arrow_full_right('\ue80a'),
    pici_arrow_full_up('\ue80b'),
    pici_arrow_full_upperleft('\ue80c'),
    pici_arrow_full_upperright('\ue80d'),
    pici_arrow_sans_down('\ue80e'),
    pici_arrow_sans_left('\ue80f'),
    pici_arrow_sans_lowerleft('\ue810'),
    pici_arrow_sans_lowerright('\ue811'),
    pici_arrow_sans_right('\ue812'),
    pici_arrow_sans_up('\ue813'),
    pici_arrow_sans_upperleft('\ue814'),
    pici_arrow_sans_upperright('\ue815'),
    pici_attachment('\ue816'),
    pici_attachment_add('\ue817'),
    pici_attachment_down('\ue818'),
    pici_avatar('\ue819'),
    pici_avatar_edit('\ue81a'),
    pici_avatar_information('\ue81b'),
    pici_backup('\ue81c'),
    pici_backup_pause('\ue81d'),
    pici_backup_run('\ue81e'),
    pici_backup_settings('\ue81f'),
    pici_backup_stop('\ue820'),
    pici_badge_accept('\ue821'),
    pici_badge_cancel('\ue822'),
    pici_badge_down('\ue823'),
    pici_badge_edit('\ue824'),
    pici_badge_eject('\ue825'),
    pici_badge_information('\ue826'),
    pici_badge_minus('\ue827'),
    pici_badge_pause('\ue828'),
    pici_badge_plus('\ue829'),
    pici_badge_run('\ue82a'),
    pici_badge_security('\ue82b'),
    pici_badge_settings('\ue82c'),
    pici_badge_stop('\ue82d'),
    pici_badge_up('\ue82e'),
    pici_baseball('\ue82f'),
    pici_basketball('\ue830'),
    pici_battery_1('\ue831'),
    pici_battery_2('\ue832'),
    pici_battery_3('\ue833'),
    pici_battery_4('\ue834'),
    pici_battery_empty('\ue835'),
    pici_battery_full('\ue836'),
    pici_battery_plugged('\ue837'),
    pici_bed('\ue838'),
    pici_book_audio('\ue839'),
    pici_book_audio_add('\ue83a'),
    pici_book_audio_eject('\ue83b'),
    pici_book_audio_information('\ue83c'),
    pici_book_audio_pause('\ue83d'),
    pici_book_audio_remove('\ue83e'),
    pici_book_audio_run('\ue83f'),
    pici_book_audio_security('\ue840'),
    pici_book_audio_settings('\ue841'),
    pici_book_audio_stop('\ue842'),
    pici_book_image('\ue843'),
    pici_book_image_add('\ue844'),
    pici_book_image_information('\ue845'),
    pici_book_image_pause('\ue846'),
    pici_book_image_remove('\ue847'),
    pici_book_image_run('\ue848'),
    pici_book_image_security('\ue849'),
    pici_book_image_settings('\ue84a'),
    pici_book_image_stop('\ue84b'),
    pici_bookmark('\ue84c'),
    pici_bookmark_settings('\ue84d'),
    pici_book_sans('\ue84e'),
    pici_book_sans_add('\ue84f'),
    pici_book_sans_down('\ue850'),
    pici_book_sans_information('\ue851'),
    pici_book_sans_remove('\ue852'),
    pici_book_sans_run('\ue853'),
    pici_book_sans_security('\ue854'),
    pici_book_sans_up('\ue855'),
    pici_book_text('\ue856'),
    pici_book_text_add('\ue857'),
    pici_book_text_down('\ue858'),
    pici_book_text_information('\ue859'),
    pici_book_text_remove('\ue85a'),
    pici_book_text_run('\ue85b'),
    pici_book_text_security('\ue85c'),
    pici_book_text_settings('\ue85d'),
    pici_book_text_stop('\ue85e'),
    pici_book_text_up('\ue85f'),
    pici_brightness_brighten('\ue860'),
    pici_brightness_darken('\ue861'),
    pici_browser_window('\ue862'),
    pici_browser_window_add('\ue863'),
    pici_browser_window_cancel('\ue864'),
    pici_browser_window_remove('\ue865'),
    pici_browser_window_security('\ue866'),
    pici_browser_window_settings('\ue867'),
    pici_buy('\ue868'),
    pici_calculator('\ue869'),
    pici_calendar('\ue86a'),
    pici_cancel('\ue86b'),
    pici_category('\ue86c'),
    pici_category_add('\ue86d'),
    pici_category_edit('\ue86e'),
    pici_category_remove('\ue86f'),
    pici_category_settings('\ue870'),
    pici_cd('\ue871'),
    pici_cd_eject('\ue872'),
    pici_cd_pause('\ue873'),
    pici_cd_run('\ue874'),
    pici_cd_security('\ue875'),
    pici_cd_stop('\ue876'),
    pici_cd_write('\ue877'),
    pici_chat('\ue878'),
    pici_chat_pause('\ue879'),
    pici_chat_run('\ue87a'),
    pici_chat_security('\ue87b'),
    pici_chat_settings('\ue87c'),
    pici_chat_stop('\ue87d'),
    pici_clock('\ue87e'),
    pici_clock_mini('\ue87f'),
    pici_cloud('\ue880'),
    pici_codec_image('\ue881'),
    pici_codec_video('\ue882'),
    pici_combine('\ue883'),
    pici_comment('\ue884'),
    pici_comment_accept('\ue885'),
    pici_comment_add('\ue886'),
    pici_comment_cancel('\ue887'),
    pici_comment_edit('\ue888'),
    pici_comment_remove('\ue889'),
    pici_comment_settings('\ue88a'),
    pici_computer('\ue88b'),
    pici_computer_accept('\ue88c'),
    pici_computer_add('\ue88d'),
    pici_computer_cancel('\ue88e'),
    pici_computer_remove('\ue88f'),
    pici_computer_settings('\ue890'),
    pici_controls_chapter_next('\ue891'),
    pici_controls_chapter_previous('\ue892'),
    pici_controls_eject('\ue893'),
    pici_controls_fast_forward('\ue894'),
    pici_controls_pause('\ue895'),
    pici_controls_play('\ue896'),
    pici_controls_play_back('\ue897'),
    pici_controls_rewind('\ue898'),
    pici_controls_stop('\ue899'),
    pici_cooler('\ue89a'),
    pici_copy('\ue89b'),
    pici_credit_card('\ue89c'),
    pici_crown('\ue89d'),
    pici_cut('\ue89e'),
    pici_database('\ue89f'),
    pici_database_add('\ue8a0'),
    pici_database_edit('\ue8a1'),
    pici_database_information('\ue8a2'),
    pici_database_remove('\ue8a3'),
    pici_database_run('\ue8a4'),
    pici_database_security('\ue8a5'),
    pici_data_privacy('\ue8a6'),
    pici_document_image('\ue8a7'),
    pici_document_image_accept('\ue8a8'),
    pici_document_image_add('\ue8a9'),
    pici_document_image_cancel('\ue8aa'),
    pici_document_image_down('\ue8ab'),
    pici_document_image_edit('\ue8ac'),
    pici_document_image_information('\ue8ad'),
    pici_document_image_remove('\ue8ae'),
    pici_document_image_run('\ue8af'),
    pici_document_image_security('\ue8b0'),
    pici_document_image_settings('\ue8b1'),
    pici_document_image_up('\ue8b2'),
    pici_document_music('\ue8b3'),
    pici_document_music_accept('\ue8b4'),
    pici_document_music_add('\ue8b5'),
    pici_document_music_cancel('\ue8b6'),
    pici_document_music_down('\ue8b7'),
    pici_document_music_edit('\ue8b8'),
    pici_document_music_information('\ue8b9'),
    pici_document_music_remove('\ue8ba'),
    pici_document_music_run('\ue8bb'),
    pici_document_music_security('\ue8bc'),
    pici_document_music_settings('\ue8bd'),
    pici_document_music_up('\ue8be'),
    pici_document_sans('\ue8bf'),
    pici_document_sans_accept('\ue8c0'),
    pici_document_sans_add('\ue8c1'),
    pici_document_sans_cancel('\ue8c2'),
    pici_document_sans_down('\ue8c3'),
    pici_document_sans_edit('\ue8c4'),
    pici_document_sans_information('\ue8c5'),
    pici_document_sans_remove('\ue8c6'),
    pici_document_sans_run('\ue8c7'),
    pici_document_sans_security('\ue8c8'),
    pici_document_sans_settings('\ue8c9'),
    pici_document_sans_up('\ue8ca'),
    pici_document_text('\ue8cb'),
    pici_document_text_accept('\ue8cc'),
    pici_document_text_add('\ue8cd'),
    pici_document_text_cancel('\ue8ce'),
    pici_document_text_down('\ue8cf'),
    pici_document_text_edit('\ue8d0'),
    pici_document_text_information('\ue8d1'),
    pici_document_text_remove('\ue8d2'),
    pici_document_text_run('\ue8d3'),
    pici_document_text_security('\ue8d4'),
    pici_document_text_settings('\ue8d5'),
    pici_document_text_up('\ue8d6'),
    pici_document_video('\ue8d7'),
    pici_document_video_accept('\ue8d8'),
    pici_document_video_add('\ue8d9'),
    pici_document_video_cancel('\ue8da'),
    pici_document_video_down('\ue8db'),
    pici_document_video_edit('\ue8dc'),
    pici_document_video_information('\ue8dd'),
    pici_document_video_remove('\ue8de'),
    pici_document_video_run('\ue8df'),
    pici_document_video_security('\ue8e0'),
    pici_document_video_settings('\ue8e1'),
    pici_document_video_up('\ue8e2'),
    pici_donate('\ue8e3'),
    pici_download('\ue8e4'),
    pici_download_accept('\ue8e5'),
    pici_download_cancel('\ue8e6'),
    pici_download_information('\ue8e7'),
    pici_download_pause('\ue8e8'),
    pici_download_run('\ue8e9'),
    pici_download_security('\ue8ea'),
    pici_download_settings('\ue8eb'),
    pici_download_stop('\ue8ec'),
    pici_dropbox('\ue8ed'),
    pici_edit('\ue8ee'),
    pici_entrance('\ue8ef'),
    pici_equal('\ue8f0'),
    pici_filepath('\ue8f1'),
    pici_filter('\ue8f2'),
    pici_filter_settings('\ue8f3'),
    pici_firewall('\ue8f4'),
    pici_firewall_pause('\ue8f5'),
    pici_firewall_run('\ue8f6'),
    pici_firewall_settings('\ue8f7'),
    pici_firewall_stop('\ue8f8'),
    pici_flag('\ue8f9'),
    pici_flash('\ue8fa'),
    pici_flash_off('\ue8fb'),
    pici_floppy_disk('\ue8fc'),
    pici_folder_downloads('\ue8fd'),
    pici_folder_image('\ue8fe'),
    pici_folder_music('\ue8ff'),
    pici_folder_sans('\ue900'),
    pici_folder_sans_accept('\ue901'),
    pici_folder_sans_add('\ue902'),
    pici_folder_sans_cancel('\ue903'),
    pici_folder_sans_down('\ue904'),
    pici_folder_sans_edit('\ue905'),
    pici_folder_sans_information('\ue906'),
    pici_folder_sans_remove('\ue907'),
    pici_folder_sans_run('\ue908'),
    pici_folder_sans_security('\ue909'),
    pici_folder_sans_settings('\ue90a'),
    pici_folder_sans_up('\ue90b'),
    pici_folder_text('\ue90c'),
    pici_folder_video('\ue90d'),
    pici_football('\ue90e'),
    pici_fullscreen('\ue90f'),
    pici_fullscreen_cancel('\ue910'),
    pici_game_controller('\ue911'),
    pici_adressbook('\ue801'),
    pici_golf('\ue913'),
    pici_group_full('\ue914'),
    pici_group_full_add('\ue915'),
    pici_group_full_edit('\ue916'),
    pici_group_full_remove('\ue917'),
    pici_group_full_security('\ue918'),
    pici_group_half('\ue919'),
    pici_group_half_add('\ue91a'),
    pici_group_half_edit('\ue91b'),
    pici_group_half_remove('\ue91c'),
    pici_group_half_security('\ue91d'),
    pici_harddisk_sans('\ue91e'),
    pici_harddisk_sans_eject('\ue91f'),
    pici_harddisk_sans_security('\ue920'),
    pici_harddisk_sans_settings('\ue921'),
    pici_hierarchy('\ue922'),
    pici_home('\ue923'),
    pici_image('\ue924'),
    pici_image_accept('\ue925'),
    pici_image_add('\ue926'),
    pici_image_cancel('\ue927'),
    pici_image_edit('\ue928'),
    pici_image_pause('\ue929'),
    pici_image_remove('\ue92a'),
    pici_image_run('\ue92b'),
    pici_image_security('\ue92c'),
    pici_image_settings('\ue92d'),
    pici_imprint('\ue92e'),
    pici_information('\ue92f'),
    pici_internet('\ue930'),
    pici_keyboard('\ue931'),
    pici_label('\ue932'),
    pici_label_add('\ue933'),
    pici_label_edit('\ue934'),
    pici_label_remove('\ue935'),
    pici_label_security('\ue936'),
    pici_leaf('\ue937'),
    pici_light('\ue938'),
    pici_light_off('\ue939'),
    pici_link('\ue93a'),
    pici_link_add('\ue93b'),
    pici_link_edit('\ue93c'),
    pici_link_remove('\ue93d'),
    pici_list('\ue93e'),
    pici_list_numbered('\ue93f'),
    pici_login('\ue940'),
    pici_logout('\ue941'),
    pici_mail('\ue942'),
    pici_mail_accept('\ue943'),
    pici_mail_add('\ue944'),
    pici_mailbox('\ue945'),
    pici_mailbox_down('\ue946'),
    pici_mailbox_eject('\ue947'),
    pici_mailbox_incoming('\ue948'),
    pici_mailbox_outgoing('\ue949'),
    pici_mailbox_settings('\ue94a'),
    pici_mail_cancel('\ue94b'),
    pici_mail_edit('\ue94c'),
    pici_mail_fwd('\ue94d'),
    pici_mail_remove('\ue94e'),
    pici_mail_run('\ue94f'),
    pici_mail_security('\ue950'),
    pici_mainframe('\ue951'),
    pici_mashup('\ue952'),
    pici_mobile_phone('\ue953'),
    pici_move('\ue954'),
    pici_music('\ue955'),
    pici_music_accept('\ue956'),
    pici_music_add('\ue957'),
    pici_music_cancel('\ue958'),
    pici_music_edit('\ue959'),
    pici_music_eject('\ue95a'),
    pici_music_information('\ue95b'),
    pici_music_pause('\ue95c'),
    pici_music_remove('\ue95d'),
    pici_music_run('\ue95e'),
    pici_music_security('\ue95f'),
    pici_music_settings('\ue960'),
    pici_music_stop('\ue961'),
    pici_network_intranet('\ue962'),
    pici_network_protocol('\ue963'),
    pici_network_sans('\ue964'),
    pici_network_sans_add('\ue965'),
    pici_network_sans_edit('\ue966'),
    pici_network_sans_remove('\ue967'),
    pici_network_sans_security('\ue968'),
    pici_network_wireless('\ue969'),
    pici_network_wireless_add('\ue96a'),
    pici_network_wireless_edit('\ue96b'),
    pici_network_wireless_security('\ue96c'),
    pici_news('\ue96d'),
    pici_notes('\ue96e'),
    pici_notes_accept('\ue96f'),
    pici_notes_add('\ue970'),
    pici_notes_cancel('\ue971'),
    pici_notes_down('\ue972'),
    pici_notes_edit('\ue973'),
    pici_notes_remove('\ue974'),
    pici_notes_settings('\ue975'),
    pici_notes_up('\ue976'),
    pici_ontology('\ue977'),
    pici_owl_dl('\ue978'),
    pici_owl_dl_document('\ue979'),
    pici_owl_full('\ue97a'),
    pici_owl_full_document('\ue97b'),
    pici_owl_lite('\ue97c'),
    pici_owl_lite_document('\ue97d'),
    pici_paragraph('\ue97e'),
    pici_paste('\ue97f'),
    pici_path('\ue980'),
    pici_pda('\ue981'),
    pici_pear('\ue982'),
    pici_phone_home('\ue983'),
    pici_phone_off('\ue984'),
    pici_phone_on('\ue985'),
    pici_pin('\ue986'),
    pici_pin_filled('\ue987'),
    pici_plus('\ue988'),
    pici_point_of_interest('\ue989'),
    pici_printer('\ue98a'),
    pici_printer_add('\ue98b'),
    pici_printer_cancel('\ue98c'),
    pici_printer_information('\ue98d'),
    pici_printer_pause('\ue98e'),
    pici_printer_remove('\ue98f'),
    pici_printer_run('\ue990'),
    pici_printer_settings('\ue991'),
    pici_printer_stop('\ue992'),
    pici_questionmark('\ue993'),
    pici_rdf('\ue994'),
    pici_rdf_document('\ue995'),
    pici_recent_changes('\ue996'),
    pici_refresh('\ue997'),
    pici_relevance('\ue998'),
    pici_remix('\ue999'),
    pici_route('\ue99a'),
    pici_satellite('\ue99b'),
    pici_satellite_ground('\ue99c'),
    pici_screen_4to3('\ue99d'),
    pici_screen_16to9('\ue99e'),
    pici_script('\ue99f'),
    pici_search('\ue9a0'),
    pici_security_closed('\ue9a1'),
    pici_security_open('\ue9a2'),
    pici_semantic_web('\ue9a3'),
    pici_server('\ue9a4'),
    pici_server_accept('\ue9a5'),
    pici_server_add('\ue9a6'),
    pici_server_cancel('\ue9a7'),
    pici_server_edit('\ue9a8'),
    pici_server_eject('\ue9a9'),
    pici_server_information('\ue9aa'),
    pici_server_remove('\ue9ab'),
    pici_server_run('\ue9ac'),
    pici_server_security('\ue9ad'),
    pici_server_settings('\ue9ae'),
    pici_server_stop('\ue9af'),
    pici_settings('\ue9b0'),
    pici_shopping_cart('\ue9b1'),
    pici_sitemap('\ue9b2'),
    pici_size_both('\ue9b3'),
    pici_size_both_accept('\ue9b4'),
    pici_size_both_add('\ue9b5'),
    pici_size_both_cancel('\ue9b6'),
    pici_size_both_edit('\ue9b7'),
    pici_size_both_remove('\ue9b8'),
    pici_size_both_security('\ue9b9'),
    pici_size_both_settings('\ue9ba'),
    pici_size_height('\ue9bb'),
    pici_size_height_accept('\ue9bc'),
    pici_size_height_add('\ue9bd'),
    pici_size_height_cancel('\ue9be'),
    pici_size_height_edit('\ue9bf'),
    pici_size_height_remove('\ue9c0'),
    pici_size_height_security('\ue9c1'),
    pici_size_height_settings('\ue9c2'),
    pici_size_width('\ue9c3'),
    pici_size_width_accept('\ue9c4'),
    pici_size_width_add('\ue9c5'),
    pici_size_width_cancel('\ue9c6'),
    pici_size_width_edit('\ue9c7'),
    pici_size_width_remove('\ue9c8'),
    pici_size_width_security('\ue9c9'),
    pici_size_width_settings('\ue9ca'),
    pici_soccer('\ue9cb'),
    pici_social_network('\ue9cc'),
    pici_source_code('\ue9cd'),
    pici_speaker_louder('\ue9ce'),
    pici_speaker_off('\ue9cf'),
    pici_speaker_silent('\ue9d0'),
    pici_star('\ue9d1'),
    pici_star_outline('\ue9d2'),
    pici_statistics('\ue9d3'),
    pici_synchronize('\ue9d4'),
    pici_tab('\ue9d5'),
    pici_tab_add('\ue9d6'),
    pici_tab_cancel('\ue9d7'),
    pici_tablet('\ue9d8'),
    pici_target('\ue9d9'),
    pici_terminal_computer('\ue9da'),
    pici_text('\ue9db'),
    pici_text_align_center('\ue9dc'),
    pici_text_align_full('\ue9dd'),
    pici_text_align_left('\ue9de'),
    pici_text_align_right('\ue9df'),
    pici_text_bold('\ue9e0'),
    pici_text_italic('\ue9e1'),
    pici_text_strikethrough('\ue9e2'),
    pici_transportation_bus('\ue9e3'),
    pici_transportation_car('\ue9e4'),
    pici_transportation_plane('\ue9e5'),
    pici_transportation_ship('\ue9e6'),
    pici_transportation_train('\ue9e7'),
    pici_transportation_truck('\ue9e8'),
    pici_trash('\ue9e9'),
    pici_trash_full('\ue9ea'),
    pici_tree('\ue9eb'),
    pici_upload('\ue9ec'),
    pici_upload_accept('\ue9ed'),
    pici_upload_cancel('\ue9ee'),
    pici_upload_pause('\ue9ef'),
    pici_upload_run('\ue9f0'),
    pici_upload_security('\ue9f1'),
    pici_upload_settings('\ue9f2'),
    pici_upload_stop('\ue9f3'),
    pici_user_close('\ue9f4'),
    pici_user_close_add('\ue9f5'),
    pici_user_close_edit('\ue9f6'),
    pici_user_close_information('\ue9f7'),
    pici_user_close_remove('\ue9f8'),
    pici_user_close_security('\ue9f9'),
    pici_user_close_settings('\ue9fa'),
    pici_user_full('\ue9fb'),
    pici_user_full_add('\ue9fc'),
    pici_user_full_edit('\ue9fd'),
    pici_user_full_information('\ue9fe'),
    pici_user_full_remove('\ue9ff'),
    pici_user_full_security('\uea00'),
    pici_user_full_settings('\uea01'),
    pici_user_half('\uea02'),
    pici_user_half_add('\uea03'),
    pici_user_half_edit('\uea04'),
    pici_user_half_information('\uea05'),
    pici_user_half_remove('\uea06'),
    pici_user_half_security('\uea07'),
    pici_user_half_settings('\uea08'),
    pici_user_profile('\uea09'),
    pici_user_profile_add('\uea0a'),
    pici_user_profile_edit('\uea0b'),
    pici_video('\uea0c'),
    pici_video_accept('\uea0d'),
    pici_video_add('\uea0e'),
    pici_video_cancel('\uea0f'),
    pici_video_down('\uea10'),
    pici_video_edit('\uea11'),
    pici_video_information('\uea12'),
    pici_video_pause('\uea13'),
    pici_video_remove('\uea14'),
    pici_video_run('\uea15'),
    pici_video_security('\uea16'),
    pici_video_settings('\uea17'),
    pici_video_stop('\uea18'),
    pici_video_up('\uea19'),
    pici_view('\uea1a'),
    pici_viewer_image('\uea1b'),
    pici_viewer_text('\uea1c'),
    pici_viewer_video('\uea1d'),
    pici_vuvuzela('\uea1e'),
    pici_website('\uea1f'),
    pici_weight('\uea20'),
    pici_xml('\uea21'),
    pici_xml_document('\uea22'),
    pici_zoom_in('\uea23'),
    pici_globe('\ue912');

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
        typeface = new Picol();
      }
      return typeface;
    }
  }
}

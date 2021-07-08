package com.rilixtech.weather_icons_typeface;

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

public class WeatherIcons implements ITypeface {
    private static final String TTF_FILE = "weather-icons-v2.0.10.ttf";
    private static final String MAPPING_FONT_PREFIX = "wici";

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
        return "Weather Icons";
    }

    @Override public String getVersion() {
        return "2.0.10";
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
        return "Erik Flowers";
    }

    @Override public String getUrl() {
        return "http://weathericons.io/";
    }

    @Override public String getDescription() {
        return "Weather Icons is the only icon font and CSS with 222 weather themed icons, ready to be dropped right into Bootstrap, or any project that needs high quality weather, maritime, and meteorological based icons!";
    }

    @Override public String getLicense() {
        return "SIL OFL 1.1";
    }

    @Override public String getLicenseUrl() {
        return "http://scripts.sil.org/cms/scripts/page.php?site_id=nrsi&id=OFL";
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
        wici_day_sunny('\uf00d'),
        wici_day_cloudy('\uf002'),
        wici_day_cloudy_gusts('\uf000'),
        wici_day_cloudy_windy('\uf001'),
        wici_day_fog('\uf003'),
        wici_day_hail('\uf004'),
        wici_day_haze('\uf0b6'),
        wici_day_lightning('\uf005'),
        wici_day_rain('\uf008'),
        wici_day_rain_mix('\uf006'),
        wici_day_rain_wind('\uf007'),
        wici_day_showers('\uf009'),
        wici_day_sleet('\uf0b2'),
        wici_day_sleet_storm('\uf068'),
        wici_day_snow('\uf00a'),
        wici_day_snow_thunderstorm('\uf06b'),
        wici_day_snow_wind('\uf065'),
        wici_day_sprinkle('\uf00b'),
        wici_day_storm_showers('\uf00e'),
        wici_day_sunny_overcast('\uf00c'),
        wici_day_thunderstorm('\uf010'),
        wici_day_windy('\uf085'),
        wici_solar_eclipse('\uf06e'),
        wici_hot('\uf072'),
        wici_day_cloudy_high('\uf07d'),
        wici_day_light_wind('\uf0c4'),
        wici_night_clear('\uf02e'),
        wici_night_alt_cloudy('\uf086'),
        wici_night_alt_cloudy_gusts('\uf022'),
        wici_night_alt_cloudy_windy('\uf023'),
        wici_night_alt_hail('\uf024'),
        wici_night_alt_lightning('\uf025'),
        wici_night_alt_rain('\uf028'),
        wici_night_alt_rain_mix('\uf026'),
        wici_night_alt_rain_wind('\uf027'),
        wici_night_alt_showers('\uf029'),
        wici_night_alt_sleet('\uf0b4'),
        wici_night_alt_sleet_storm('\uf06a'),
        wici_night_alt_snow('\uf02a'),
        wici_night_alt_snow_thunderstorm('\uf06d'),
        wici_night_alt_snow_wind('\uf067'),
        wici_night_alt_sprinkle('\uf02b'),
        wici_night_alt_storm_showers('\uf02c'),
        wici_night_alt_thunderstorm('\uf02d'),
        wici_night_cloudy('\uf031'),
        wici_night_cloudy_gusts('\uf02f'),
        wici_night_cloudy_windy('\uf030'),
        wici_night_fog('\uf04a'),
        wici_night_hail('\uf032'),
        wici_night_lightning('\uf033'),
        wici_night_partly_cloudy('\uf083'),
        wici_night_rain('\uf036'),
        wici_night_rain_mix('\uf034'),
        wici_night_rain_wind('\uf035'),
        wici_night_showers('\uf037'),
        wici_night_sleet('\uf0b3'),
        wici_night_sleet_storm('\uf069'),
        wici_night_snow('\uf038'),
        wici_night_snow_thunderstorm('\uf06c'),
        wici_night_snow_wind('\uf066'),
        wici_night_sprinkle('\uf039'),
        wici_night_storm_showers('\uf03a'),
        wici_night_thunderstorm('\uf03b'),
        wici_lunar_eclipse('\uf070'),
        wici_stars('\uf077'),
        wici_night_alt_cloudy_high('\uf07e'),
        wici_night_cloudy_high('\uf080'),
        wici_night_alt_partly_cloudy('\uf081'),
        wici_cloud('\uf041'),
        wici_cloudy('\uf013'),
        wici_cloudy_gusts('\uf011'),
        wici_cloudy_windy('\uf012'),
        wici_fog('\uf014'),
        wici_hail('\uf015'),
        wici_rain('\uf019'),
        wici_rain_mix('\uf017'),
        wici_rain_wind('\uf018'),
        wici_showers('\uf01a'),
        wici_sleet('\uf0b5'),
        wici_sprinkle('\uf01c'),
        wici_storm_showers('\uf01d'),
        wici_thunderstorm('\uf01e'),
        wici_snow_wind('\uf064'),
        wici_snow('\uf01b'),
        wici_smog('\uf074'),
        wici_smoke('\uf062'),
        wici_lightning('\uf016'),
        wici_raindrops('\uf04e'),
        wici_raindrop('\uf078'),
        wici_dust('\uf063'),
        wici_snowflake_cold('\uf076'),
        wici_windy('\uf021'),
        wici_strong_wind('\uf050'),
        wici_sandstorm('\uf082'),
        wici_earthquake('\uf0c6'),
        wici_fire('\uf0c7'),
        wici_flood('\uf07c'),
        wici_meteor('\uf071'),
        wici_tsunami('\uf0c5'),
        wici_volcano('\uf0c8'),
        wici_hurricane('\uf073'),
        wici_tornado('\uf056'),
        wici_small_craft_advisory('\uf0cc'),
        wici_gale_warning('\uf0cd'),
        wici_storm_warning('\uf0ce'),
        wici_hurricane_warning('\uf0cf'),
        wici_wind_direction('\uf0b1'),
        wici_alien('\uf075'),
        wici_celsius('\uf03c'),
        wici_fahrenheit('\uf045'),
        wici_degrees('\uf042'),
        wici_thermometer('\uf055'),
        wici_thermometer_exterior('\uf053'),
        wici_thermometer_internal('\uf054'),
        wici_cloud_down('\uf03d'),
        wici_cloud_up('\uf040'),
        wici_cloud_refresh('\uf03e'),
        wici_horizon('\uf047'),
        wici_horizon_alt('\uf046'),
        wici_sunrise('\uf051'),
        wici_sunset('\uf052'),
        wici_moonrise('\uf0c9'),
        wici_moonset('\uf0ca'),
        wici_refresh('\uf04c'),
        wici_refresh_alt('\uf04b'),
        wici_umbrella('\uf084'),
        wici_barometer('\uf079'),
        wici_humidity('\uf07a'),
        wici_na('\uf07b'),
        wici_train('\uf0cb'),
        wici_moon_new('\uf095'),
        wici_moon_waxing_crescenti_1('\uf096'),
        wici_moon_waxing_crescenti_2('\uf097'),
        wici_moon_waxing_crescenti_3('\uf098'),
        wici_moon_waxing_crescenti_4('\uf099'),
        wici_moon_waxing_crescenti_5('\uf09a'),
        wici_moon_waxing_crescenti_6('\uf09b'),
        wici_moon_first_quarter('\uf09c'),
        wici_moon_waxing_gibbous_1('\uf09d'),
        wici_moon_waxing_gibbous_2('\uf09e'),
        wici_moon_waxing_gibbous_3('\uf09f'),
        wici_moon_waxing_gibbous_4('\uf0a0'),
        wici_moon_waxing_gibbous_5('\uf0a1'),
        wici_moon_waxing_gibbous_6('\uf0a2'),
        wici_moon_full('\uf0a3'),
        wici_moon_waning_gibbous_1('\uf0a4'),
        wici_moon_waning_gibbous_2('\uf0a5'),
        wici_moon_waning_gibbous_3('\uf0a6'),
        wici_moon_waning_gibbous_4('\uf0a7'),
        wici_moon_waning_gibbous_5('\uf0a8'),
        wici_moon_waning_gibbous_6('\uf0a9'),
        wici_moon_third_quarter('\uf0aa'),
        wici_moon_waning_crescenti_1('\uf0ab'),
        wici_moon_waning_crescenti_2('\uf0ac'),
        wici_moon_waning_crescenti_3('\uf0ad'),
        wici_moon_waning_crescenti_4('\uf0ae'),
        wici_moon_waning_crescenti_5('\uf0af'),
        wici_moon_waning_crescenti_6('\uf0b0'),
        wici_moon_alt_new('\uf0eb'),
        wici_moon_alt_waxing_crescenti_1('\uf0d0'),
        wici_moon_alt_waxing_crescenti_2('\uf0d1'),
        wici_moon_alt_waxing_crescenti_3('\uf0d2'),
        wici_moon_alt_waxing_crescenti_4('\uf0d3'),
        wici_moon_alt_waxing_crescenti_5('\uf0d4'),
        wici_moon_alt_waxing_crescenti_6('\uf0d5'),
        wici_moon_alt_first_quarter('\uf0d6'),
        wici_moon_alt_waxing_gibbous_1('\uf0d7'),
        wici_moon_alt_waxing_gibbous_2('\uf0d8'),
        wici_moon_alt_waxing_gibbous_3('\uf0d9'),
        wici_moon_alt_waxing_gibbous_4('\uf0da'),
        wici_moon_alt_waxing_gibbous_5('\uf0db'),
        wici_moon_alt_waxing_gibbous_6('\uf0dc'),
        wici_moon_alt_full('\uf0dd'),
        wici_moon_alt_waning_gibbous_1('\uf0de'),
        wici_moon_alt_waning_gibbous_2('\uf0df'),
        wici_moon_alt_waning_gibbous_3('\uf0e0'),
        wici_moon_alt_waning_gibbous_4('\uf0e1'),
        wici_moon_alt_waning_gibbous_5('\uf0e2'),
        wici_moon_alt_waning_gibbous_6('\uf0e3'),
        wici_moon_alt_third_quarter('\uf0e4'),
        wici_moon_alt_waning_crescenti_1('\uf0e5'),
        wici_moon_alt_waning_crescenti_2('\uf0e6'),
        wici_moon_alt_waning_crescenti_3('\uf0e7'),
        wici_moon_alt_waning_crescenti_4('\uf0e8'),
        wici_moon_alt_waning_crescenti_5('\uf0e9'),
        wici_moon_alt_waning_crescenti_6('\uf0ea'),
        wici_moon_0('\uf095'),
        wici_moon_1('\uf096'),
        wici_moon_2('\uf097'),
        wici_moon_3('\uf098'),
        wici_moon_4('\uf099'),
        wici_moon_5('\uf09a'),
        wici_moon_6('\uf09b'),
        wici_moon_7('\uf09c'),
        wici_moon_8('\uf09d'),
        wici_moon_9('\uf09e'),
        wici_moon_10('\uf09f'),
        wici_moon_11('\uf0a0'),
        wici_moon_12('\uf0a1'),
        wici_moon_13('\uf0a2'),
        wici_moon_14('\uf0a3'),
        wici_moon_15('\uf0a4'),
        wici_moon_16('\uf0a5'),
        wici_moon_17('\uf0a6'),
        wici_moon_18('\uf0a7'),
        wici_moon_19('\uf0a8'),
        wici_moon_20('\uf0a9'),
        wici_moon_21('\uf0aa'),
        wici_moon_22('\uf0ab'),
        wici_moon_23('\uf0ac'),
        wici_moon_24('\uf0ad'),
        wici_moon_25('\uf0ae'),
        wici_moon_26('\uf0af'),
        wici_moon_27('\uf0b0'),
        wici_time_1('\uf08a'),
        wici_time_2('\uf08b'),
        wici_time_3('\uf08c'),
        wici_time_4('\uf08d'),
        wici_time_5('\uf08e'),
        wici_time_6('\uf08f'),
        wici_time_7('\uf090'),
        wici_time_8('\uf091'),
        wici_time_9('\uf092'),
        wici_time_10('\uf093'),
        wici_time_11('\uf094'),
        wici_time_12('\uf089'),
        wici_direction_up('\uf058'),
        wici_direction_up_right('\uf057'),
        wici_direction_right('\uf04d'),
        wici_direction_down_right('\uf088'),
        wici_direction_down('\uf044'),
        wici_direction_down_left('\uf043'),
        wici_direction_left('\uf048'),
        wici_direction_up_left('\uf087'),
        wici_wind_beaufort_0('\uf0b7'),
        wici_wind_beaufort_1('\uf0b8'),
        wici_wind_beaufort_2('\uf0b9'),
        wici_wind_beaufort_3('\uf0ba'),
        wici_wind_beaufort_4('\uf0bb'),
        wici_wind_beaufort_5('\uf0bc'),
        wici_wind_beaufort_6('\uf0bd'),
        wici_wind_beaufort_7('\uf0be'),
        wici_wind_beaufort_8('\uf0bf'),
        wici_wind_beaufort_9('\uf0c0'),
        wici_wind_beaufort_10('\uf0c1'),
        wici_wind_beaufort_11('\uf0c2'),
        wici_wind_beaufort_12('\uf0c3'),
        wici_yahoo_0('\uf056'),
        wici_yahoo_1('\uf00e'),
        wici_yahoo_2('\uf073'),
        wici_yahoo_3('\uf01e'),
        wici_yahoo_4('\uf01e'),
        wici_yahoo_5('\uf017'),
        wici_yahoo_6('\uf017'),
        wici_yahoo_7('\uf017'),
        wici_yahoo_8('\uf015'),
        wici_yahoo_9('\uf01a'),
        wici_yahoo_10('\uf015'),
        wici_yahoo_11('\uf01a'),
        wici_yahoo_12('\uf01a'),
        wici_yahoo_13('\uf01b'),
        wici_yahoo_14('\uf00a'),
        wici_yahoo_15('\uf064'),
        wici_yahoo_16('\uf01b'),
        wici_yahoo_17('\uf015'),
        wici_yahoo_18('\uf017'),
        wici_yahoo_19('\uf063'),
        wici_yahoo_20('\uf014'),
        wici_yahoo_21('\uf021'),
        wici_yahoo_22('\uf062'),
        wici_yahoo_23('\uf050'),
        wici_yahoo_24('\uf050'),
        wici_yahoo_25('\uf076'),
        wici_yahoo_26('\uf013'),
        wici_yahoo_27('\uf031'),
        wici_yahoo_28('\uf002'),
        wici_yahoo_29('\uf031'),
        wici_yahoo_30('\uf002'),
        wici_yahoo_31('\uf02e'),
        wici_yahoo_32('\uf00d'),
        wici_yahoo_33('\uf083'),
        wici_yahoo_34('\uf00c'),
        wici_yahoo_35('\uf017'),
        wici_yahoo_36('\uf072'),
        wici_yahoo_37('\uf00e'),
        wici_yahoo_38('\uf00e'),
        wici_yahoo_39('\uf00e'),
        wici_yahoo_40('\uf01a'),
        wici_yahoo_41('\uf064'),
        wici_yahoo_42('\uf01b'),
        wici_yahoo_43('\uf064'),
        wici_yahoo_44('\uf00c'),
        wici_yahoo_45('\uf00e'),
        wici_yahoo_46('\uf01b'),
        wici_yahoo_47('\uf00e'),
        wici_yahoo_3200('\uf077'),
        wici_forecast_io_clear_day('\uf00d'),
        wici_forecast_io_clear_night('\uf02e'),
        wici_forecast_io_rain('\uf019'),
        wici_forecast_io_snow('\uf01b'),
        wici_forecast_io_sleet('\uf0b5'),
        wici_forecast_io_wind('\uf050'),
        wici_forecast_io_fog('\uf014'),
        wici_forecast_io_cloudy('\uf013'),
        wici_forecast_io_partly_cloudy_day('\uf002'),
        wici_forecast_io_partly_cloudy_night('\uf031'),
        wici_forecast_io_hail('\uf015'),
        wici_forecast_io_thunderstorm('\uf01e'),
        wici_forecast_io_tornado('\uf056'),
        wici_wmo4680_0('\uf055'),
        wici_wmo4680_00('\uf055'),
        wici_wmo4680_1('\uf013'),
        wici_wmo4680_01('\uf013'),
        wici_wmo4680_2('\uf055'),
        wici_wmo4680_02('\uf055'),
        wici_wmo4680_3('\uf013'),
        wici_wmo4680_03('\uf013'),
        wici_wmo4680_4('\uf014'),
        wici_wmo4680_04('\uf014'),
        wici_wmo4680_5('\uf014'),
        wici_wmo4680_05('\uf014'),
        wici_wmo4680_10('\uf014'),
        wici_wmo4680_11('\uf014'),
        wici_wmo4680_12('\uf016'),
        wici_wmo4680_18('\uf050'),
        wici_wmo4680_20('\uf014'),
        wici_wmo4680_21('\uf017'),
        wici_wmo4680_22('\uf017'),
        wici_wmo4680_23('\uf019'),
        wici_wmo4680_24('\uf01b'),
        wici_wmo4680_25('\uf015'),
        wici_wmo4680_26('\uf01e'),
        wici_wmo4680_27('\uf063'),
        wici_wmo4680_28('\uf063'),
        wici_wmo4680_29('\uf063'),
        wici_wmo4680_30('\uf014'),
        wici_wmo4680_31('\uf014'),
        wici_wmo4680_32('\uf014'),
        wici_wmo4680_33('\uf014'),
        wici_wmo4680_34('\uf014'),
        wici_wmo4680_35('\uf014'),
        wici_wmo4680_40('\uf017'),
        wici_wmo4680_41('\uf01c'),
        wici_wmo4680_42('\uf019'),
        wici_wmo4680_43('\uf01c'),
        wici_wmo4680_44('\uf019'),
        wici_wmo4680_45('\uf015'),
        wici_wmo4680_46('\uf015'),
        wici_wmo4680_47('\uf01b'),
        wici_wmo4680_48('\uf01b'),
        wici_wmo4680_50('\uf01c'),
        wici_wmo4680_51('\uf01c'),
        wici_wmo4680_52('\uf019'),
        wici_wmo4680_53('\uf019'),
        wici_wmo4680_54('\uf076'),
        wici_wmo4680_55('\uf076'),
        wici_wmo4680_56('\uf076'),
        wici_wmo4680_57('\uf01c'),
        wici_wmo4680_58('\uf019'),
        wici_wmo4680_60('\uf01c'),
        wici_wmo4680_61('\uf01c'),
        wici_wmo4680_62('\uf019'),
        wici_wmo4680_63('\uf019'),
        wici_wmo4680_64('\uf015'),
        wici_wmo4680_65('\uf015'),
        wici_wmo4680_66('\uf015'),
        wici_wmo4680_67('\uf017'),
        wici_wmo4680_68('\uf017'),
        wici_wmo4680_70('\uf01b'),
        wici_wmo4680_71('\uf01b'),
        wici_wmo4680_72('\uf01b'),
        wici_wmo4680_73('\uf01b'),
        wici_wmo4680_74('\uf076'),
        wici_wmo4680_75('\uf076'),
        wici_wmo4680_76('\uf076'),
        wici_wmo4680_77('\uf01b'),
        wici_wmo4680_78('\uf076'),
        wici_wmo4680_80('\uf019'),
        wici_wmo4680_81('\uf01c'),
        wici_wmo4680_82('\uf019'),
        wici_wmo4680_83('\uf019'),
        wici_wmo4680_84('\uf01d'),
        wici_wmo4680_85('\uf017'),
        wici_wmo4680_86('\uf017'),
        wici_wmo4680_87('\uf017'),
        wici_wmo4680_89('\uf015'),
        wici_wmo4680_90('\uf016'),
        wici_wmo4680_91('\uf01d'),
        wici_wmo4680_92('\uf01e'),
        wici_wmo4680_93('\uf01e'),
        wici_wmo4680_94('\uf016'),
        wici_wmo4680_95('\uf01e'),
        wici_wmo4680_96('\uf01e'),
        wici_wmo4680_99('\uf056'),
        wici_owm_200('\uf01e'),
        wici_owm_201('\uf01e'),
        wici_owm_202('\uf01e'),
        wici_owm_210('\uf016'),
        wici_owm_211('\uf016'),
        wici_owm_212('\uf016'),
        wici_owm_221('\uf016'),
        wici_owm_230('\uf01e'),
        wici_owm_231('\uf01e'),
        wici_owm_232('\uf01e'),
        wici_owm_300('\uf01c'),
        wici_owm_301('\uf01c'),
        wici_owm_302('\uf019'),
        wici_owm_310('\uf017'),
        wici_owm_311('\uf019'),
        wici_owm_312('\uf019'),
        wici_owm_313('\uf01a'),
        wici_owm_314('\uf019'),
        wici_owm_321('\uf01c'),
        wici_owm_500('\uf01c'),
        wici_owm_501('\uf019'),
        wici_owm_502('\uf019'),
        wici_owm_503('\uf019'),
        wici_owm_504('\uf019'),
        wici_owm_511('\uf017'),
        wici_owm_520('\uf01a'),
        wici_owm_521('\uf01a'),
        wici_owm_522('\uf01a'),
        wici_owm_531('\uf01d'),
        wici_owm_600('\uf01b'),
        wici_owm_601('\uf01b'),
        wici_owm_602('\uf0b5'),
        wici_owm_611('\uf017'),
        wici_owm_612('\uf017'),
        wici_owm_615('\uf017'),
        wici_owm_616('\uf017'),
        wici_owm_620('\uf017'),
        wici_owm_621('\uf01b'),
        wici_owm_622('\uf01b'),
        wici_owm_701('\uf01a'),
        wici_owm_711('\uf062'),
        wici_owm_721('\uf0b6'),
        wici_owm_731('\uf063'),
        wici_owm_741('\uf014'),
        wici_owm_761('\uf063'),
        wici_owm_762('\uf063'),
        wici_owm_771('\uf011'),
        wici_owm_781('\uf056'),
        wici_owm_800('\uf00d'),
        wici_owm_801('\uf011'),
        wici_owm_802('\uf011'),
        wici_owm_803('\uf012'),
        wici_owm_804('\uf013'),
        wici_owm_900('\uf056'),
        wici_owm_901('\uf01d'),
        wici_owm_902('\uf073'),
        wici_owm_903('\uf076'),
        wici_owm_904('\uf072'),
        wici_owm_905('\uf021'),
        wici_owm_906('\uf015'),
        wici_owm_957('\uf050'),
        wici_owm_day_200('\uf010'),
        wici_owm_day_201('\uf010'),
        wici_owm_day_202('\uf010'),
        wici_owm_day_210('\uf005'),
        wici_owm_day_211('\uf005'),
        wici_owm_day_212('\uf005'),
        wici_owm_day_221('\uf005'),
        wici_owm_day_230('\uf010'),
        wici_owm_day_231('\uf010'),
        wici_owm_day_232('\uf010'),
        wici_owm_day_300('\uf00b'),
        wici_owm_day_301('\uf00b'),
        wici_owm_day_302('\uf008'),
        wici_owm_day_310('\uf008'),
        wici_owm_day_311('\uf008'),
        wici_owm_day_312('\uf008'),
        wici_owm_day_313('\uf008'),
        wici_owm_day_314('\uf008'),
        wici_owm_day_321('\uf00b'),
        wici_owm_day_500('\uf00b'),
        wici_owm_day_501('\uf008'),
        wici_owm_day_502('\uf008'),
        wici_owm_day_503('\uf008'),
        wici_owm_day_504('\uf008'),
        wici_owm_day_511('\uf006'),
        wici_owm_day_520('\uf009'),
        wici_owm_day_521('\uf009'),
        wici_owm_day_522('\uf009'),
        wici_owm_day_531('\uf00e'),
        wici_owm_day_600('\uf00a'),
        wici_owm_day_601('\uf0b2'),
        wici_owm_day_602('\uf00a'),
        wici_owm_day_611('\uf006'),
        wici_owm_day_612('\uf006'),
        wici_owm_day_615('\uf006'),
        wici_owm_day_616('\uf006'),
        wici_owm_day_620('\uf006'),
        wici_owm_day_621('\uf00a'),
        wici_owm_day_622('\uf00a'),
        wici_owm_day_701('\uf009'),
        wici_owm_day_711('\uf062'),
        wici_owm_day_721('\uf0b6'),
        wici_owm_day_731('\uf063'),
        wici_owm_day_741('\uf003'),
        wici_owm_day_761('\uf063'),
        wici_owm_day_762('\uf063'),
        wici_owm_day_781('\uf056'),
        wici_owm_day_800('\uf00d'),
        wici_owm_day_801('\uf000'),
        wici_owm_day_802('\uf000'),
        wici_owm_day_803('\uf000'),
        wici_owm_day_804('\uf00c'),
        wici_owm_day_900('\uf056'),
        wici_owm_day_902('\uf073'),
        wici_owm_day_903('\uf076'),
        wici_owm_day_904('\uf072'),
        wici_owm_day_906('\uf004'),
        wici_owm_day_957('\uf050'),
        wici_owm_night_200('\uf02d'),
        wici_owm_night_201('\uf02d'),
        wici_owm_night_202('\uf02d'),
        wici_owm_night_210('\uf025'),
        wici_owm_night_211('\uf025'),
        wici_owm_night_212('\uf025'),
        wici_owm_night_221('\uf025'),
        wici_owm_night_230('\uf02d'),
        wici_owm_night_231('\uf02d'),
        wici_owm_night_232('\uf02d'),
        wici_owm_night_300('\uf02b'),
        wici_owm_night_301('\uf02b'),
        wici_owm_night_302('\uf028'),
        wici_owm_night_310('\uf028'),
        wici_owm_night_311('\uf028'),
        wici_owm_night_312('\uf028'),
        wici_owm_night_313('\uf028'),
        wici_owm_night_314('\uf028'),
        wici_owm_night_321('\uf02b'),
        wici_owm_night_500('\uf02b'),
        wici_owm_night_501('\uf028'),
        wici_owm_night_502('\uf028'),
        wici_owm_night_503('\uf028'),
        wici_owm_night_504('\uf028'),
        wici_owm_night_511('\uf026'),
        wici_owm_night_520('\uf029'),
        wici_owm_night_521('\uf029'),
        wici_owm_night_522('\uf029'),
        wici_owm_night_531('\uf02c'),
        wici_owm_night_600('\uf02a'),
        wici_owm_night_601('\uf0b4'),
        wici_owm_night_602('\uf02a'),
        wici_owm_night_611('\uf026'),
        wici_owm_night_612('\uf026'),
        wici_owm_night_615('\uf026'),
        wici_owm_night_616('\uf026'),
        wici_owm_night_620('\uf026'),
        wici_owm_night_621('\uf02a'),
        wici_owm_night_622('\uf02a'),
        wici_owm_night_701('\uf029'),
        wici_owm_night_711('\uf062'),
        wici_owm_night_721('\uf0b6'),
        wici_owm_night_731('\uf063'),
        wici_owm_night_741('\uf04a'),
        wici_owm_night_761('\uf063'),
        wici_owm_night_762('\uf063'),
        wici_owm_night_781('\uf056'),
        wici_owm_night_800('\uf02e'),
        wici_owm_night_801('\uf022'),
        wici_owm_night_802('\uf022'),
        wici_owm_night_803('\uf022'),
        wici_owm_night_804('\uf086'),
        wici_owm_night_900('\uf056'),
        wici_owm_night_902('\uf073'),
        wici_owm_night_903('\uf076'),
        wici_owm_night_904('\uf072'),
        wici_owm_night_906('\uf024'),
        wici_owm_night_957('\uf050'),
        wici_wu_chanceflurries('\uf064'),
        wici_wu_chancerain('\uf019'),
        wici_wu_chancesleat('\uf0b5'),
        wici_wu_chancesnow('\uf01b'),
        wici_wu_chancetstorms('\uf01e'),
        wici_wu_clear('\uf00d'),
        wici_wu_cloudy('\uf002'),
        wici_wu_flurries('\uf064'),
        wici_wu_hazy('\uf0b6'),
        wici_wu_mostlycloudy('\uf002'),
        wici_wu_mostlysunny('\uf00d'),
        wici_wu_partlycloudy('\uf002'),
        wici_wu_partlysunny('\uf00d'),
        wici_wu_rain('\uf01a'),
        wici_wu_sleat('\uf0b5'),
        wici_wu_snow('\uf01b'),
        wici_wu_sunny('\uf00d'),
        wici_wu_tstorms('\uf01e'),
        wici_wu_unknown('\uf00d');

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
                typeface = new WeatherIcons();
            }
            return typeface;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fsorter.ExtManager;

import java.util.EnumSet;

/**
 *
 * @author Jake Rybicki <Jake at lansoftprogramming.com>
 */
public class Extensions {
//    public static class Graphics{
//        public static Graphics getAll(){
//            System.out.println(colourPallet.values());
////            return EnumSet.of(colourPallet.values(),vector.values());
////            return colourPallet<Graphics>;
//            return colourPallet;
//        }
//        public enum colourPallet{
//            _one,_two
//        }
//        public enum Rester{
//            _info,_tof,_one,_two
//        }
//        public enum vector{
////            inner(Rester.values(),,asdaddas){};
//        }
//    }
    public enum Audio{
        _ape,_3gp,_aa,_aac,_aax,_act,_aiff,_amr,_au,awb,_dct,_dss,_dvf,
        _flac,_gsm,_iklax,_ivs,_m4a,_m4b,_m4p,_mmf,_mp3,_mpc,_msv,_nmf,_nsf,
        _oga,_mogg,_ogg,_opus,_ra,_rm,_raw,_sln,_tta,_vox,_wav,_wma,_wv,
        _webm,_8svx
    };
    public enum Video{
        _webm,_mkv,_flv,_vob,_ogv,_drc,_gif,_gifv,_mng,_avi,_MTS,_mov,_wmv,_yuv,
        _rm,_rmvb,_asf,_amv,_mp4,_mpg,_m4v,_svi,_3gp,_3g2,_mxf,_roq,_nsv,
        _ogg,_M2TS,_qt,_m4p,_mpv,_mpe,_mp2,_m2v,_mpeg,_f4b,_f4a,_f4p,_f4v,
    }
    
    public enum Image{
        _abc,_adrg,_adri,_afdesign,_afphoto,_ai,_pix,_matte,_mask,_alpha,_als,
        _ami,_ani,_iff,_anim,_png,_icns,_apx,_art,_artb,_ansi,_aas,_aab,_x32,
        _u32,_vox,_dxf,_awd,_arw,_bay,_btf,_tiff,_tif,_bmp,_dib,_rle,_2bp,
        _2bpp,_hpc,_blend,_bpg,_brk,_BSV,_cam,_cadrg,_cal,_cals,_ras,_dcl,
        _cap,_crw,_ciff,_cr2,_cdr,_ccx,_cdt,_cmx,_cgm,_cin,_pat,_cpc,_cpi,
        _jpg,_jpe,_jpeg,_cpt,_ca1,_ca2,_ca3,_cut,_cmyk,_cmyka,_dcs,_dcr,_dds,
        _pi1,_pi2,_pi3,_pc1,_pc2,_pc3,_dng,_dia,_dcm,_dicom,_djvu,_djv,_doo,
        _dpx,_drf,_epi,_eps,_eps2,_eps3,_epsf,_epsi,_ept,_ecw,_edg,_emf,_emz,
        _erf,_eri,_exif,_eva,_exr,_ff,_fif,_fig,_fit,_fits,_fla,_fli,_flc,_flx,
        _flh,_flt,_flif,_flf,_fpx,_fh4,_fh5,_fh7,_fh8,_fhc,_fh,_spl,_fxt,_xml,
        _gbr,_gif,_gfa,_giff,_xjt,_xjtgz,_xjtbz2,_gih,_gra,_g3,_3fr,_fff,_heif,
        _heic,_hg,_iiq,_ima,_img,_im4,_svg,_svgz,_ico,_cur,_ics,_ids,_igs,_ilbm,
        _lbm,_jbig,_bie,_jbg,_jng,_jif,_jfif,_jfi,_jp2,_j2c,_jpc,_j2k,_jpx,
        _jls,_wdp,_hdp,_jxr,_j6i,_kdc,_koa,_gg,_kif,_kiff,_cel,_pcd,_kqp,
        _k25,_mos,_lsp,_pnt,_mac,_mdc,_met,_mng,_mda,_ica,_mmr,_afp,_msp,_myd,
        _myv,_nef,_mef,_neo,_mag,_mki,_miff,_msa,_msl,_mvg,_mpc,_mrw,_oaz,_odg,
        _ora,_orf,_ortl,_pam,_raw,_rw2,_pcf,_prc,_pbm,_pcx,_pcc,_dcx,_epdf,
        _pdn,_pef,_pgf,_pgm,_pcs,_pnm,_ptx,_pi,_pict,_pic,_pct,_pct1,_pct2,
        _p2,_pld,_pmp,_ps,_ps2,_ps3,_ppm,_psd,_psb,_pdb,_pdd,_psp,_tub,_pspimage,
        _tim,_tm2,_str,_pxa,_qtif,_qti,_qif,_q0,_q4,_rad,_raf,_rgb,_rgba,_hdr,
        _rhif,_r3d,_sai,_sct,_sda,_sdd,_sfw,_pwp,_sgb,_sgi,_bw,_int,
        _inta,_icon,_dir,_dxr,_fgd,_shape,_sk,_skp,_skb,_sml,_srf,_sr2,_sun,
        _rs,_im1,_im8,_im24,_im32,_stx,_st4,_st5,_st6,_st7,_st8,_st9,
        _sgx,_swf,_sxd,_tga,_tpic,_tny,_tn1,_tn2,_tn3,_tn4,_tn5,_tn6,_tlg,_ufo,
        _htm,_html,_wbmp,_wbm,_wbp,_webp,_wfx,_fxs,_fxo,_wmf,_wmz,_wpg,_xaml,
        _xar,_xbm,_bm,_bitmap,_xcf,_xcfbz2,_xcfgz,_xpm,_pm,_x3f,_xwd,_x11,_xyz,
        _ycbcr,_ycbcra,_yuv,_zdt
    }
    public enum Text{
        _0, _1ST,_600,_602,_ABW,_ACL,_AFP,_AMI,_Amigaguid,_ANS,_ASC,_AWW,_CCF,
        _CSV,_CWK,_DBK,_DITA,_DOC,_DOCM,_DOT,_DOTX,_EGT,_EPUB,_EZW,_FDX,
        _FTM,_FTX,_GDOC,_HTML,_HWP,_HWPML,_LOG,_LWP,_MBP,_MD,_ME,_MCW,_Mobi,
        _NB,_NBP,_NEIS,_ODM,_ODOC,_ODT,_OSHEET,_OTT,_OMM,_PAGES,_PAP,_PDAX,_PDF,
        _QUOX,_Radix,_RTF,_RPT,_SDW,_SE,_STW,_Sxw,_TeX,_INFO,_Troff,_TXT,_UOF,
        _UOML,_VIA,_WPD,_WPS,_WPT,_WRD,_WRF,_WRI,_XHTML,_xht, _XML, _XPS,
        _CSS,_INI,_JSON,_TSV,_YAML,_rst,_md, _ahk
    }
    public enum Archive{
        _a,_ar,_cpio,_shar,_LBR,_iso,_lbr,_mar,_sbx,_tar,_bz2,_F,_gz,_lz,_lzma,
        _lzo,_rz,_sfark,_sz,_xz,_z,_7z,_s7z,_ace,_afa,_alz,_apk,_arc,_arj,_b1,
        _b6z,_ba,_bh,_cab,_car,_cfs,_cpt,_dar,_dd,_dgc,_dmg,_ear,_gca,_ha,_hki,
        _ice,_jar,_kgb,_lzh,_lzx,_pak,_lha,_partimg,_paq6,_paq7,_paq8,_paq9,
        _paq10,_pea,_pim,_pit,_qda,_rar,_rk,_sda,_sea,_sen,_sfx,_shk,_sit,_sitx,
        _sqx,_tgz,_Z,_tbz2,_tlz,_txz,_uc,_uc0,_uc2,_ucn,_ur2,_ue2,_uca,
        _uha,_war,_wim,_xar,_xp3,_yz1,_zip,_zipx,_zoo,_zpaq,_zz,
    }
    public enum Docs{
        _GSLIDES,_KEY,_KEYNOTE,_NB,_NBP,_ODP,_OTP,_PEZ,_POT,_PPS,_PPT,_PPTX,_PRZ,
        _SDD,_SHF,_SHOW,_SHW,_SLP,_SSPSS,_STI,_SXI,_THMX,_WATCH,_0,_1ST,_600,_602,
        _ABW,_ACL,_AFP,_AMI,_Amigaguide,_ANS,_ASC,_AWW,_CCF,_CSV,_CWK,_DBK,_DITA,
        _DOC,_DOCM,_DOCX,_DOT,_DOTX,_EGT,_EPUB,_EZW,_FDX,_FTM,_FTX,_GDOC,_HTML
        ,_HWP,_HWPML,_LOG,_LWP,_MBP,_MD,_ME,_MCW,_Mobi,_NEIS,_ODM,
        _ODOC,_ODT,_OSHEET,_OTT,_OMM,_PAGES,_PAP,_PDAX,_PDF,_QUOX,_Radix,_RTF,
        _RPT,_SDW,_SE,_STW,_Sxw,_TeX,_INFO,_Troff,_TXT,_UOF,_UOML,_VIA,_WPD,
        _WPS,_WPT,_WRD,_WRF,_WRI,_XHTML,_xht,_XML,_XPS,_123,_AB2,_AB3,_AWS,
        _BCSV,_CLF,_CELL,_GSHEET,_numbers,_gnumeric,_LCW,_ODS,_OTS,_QPW,
        _SDC,_SLK,_STC,_SXC,_TAB,_VC,_WK1,_WK3,_WK4,_WKS,_WQ1,_XLK,
        _XLS,_XLSB,_XLSM,_XLSX,_XLR,_XLT,_XLTM,_XLW,_mpp, _accdb, _pub, _vsdx
    }
        
}

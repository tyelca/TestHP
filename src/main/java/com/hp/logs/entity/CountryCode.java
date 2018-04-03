package com.hp.logs.entity;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hp.logs.CountryCodeSerializer;

@JsonSerialize (using=CountryCodeSerializer.class)
public enum CountryCode {

	NORTH_AMERICA	(1  ),
	EGYPT	(20 ),
	MOROCCO	(212),
	ALGERIA	(213),
	TUNISIA	(216),
	LIBYA	(217),
	GAMBIA	(220),
	SENEGAL	(221),
	MAURITANIA	(222),
	MALI	(223),
	GUINEA	(224),
	CTE_DIVOIRE	(225),
	BURKINA_FASO	(226),
	NIGER	(227),
	TOGO	(228),
	BENIN	(229),
	MAURITIUS	(230),
	LIBERIA	(231),
	SIERRA_LEONE	(232),
	GHANA	(233),
	CHAD	(234),
	CENTRAL_AFRICAN_REPUBLIC	(235),
	CAMEROON	(236),
	CAPE_VERDE	(237),
	SAO_TOM_AND_PRNCIPE	(239),
	EQUATORIAL_GUINEA	(240),
	REPUBLIC_OF_THE_CONGO	(241),
	CONGO	(243),
	ANGOLA	(244),
	GUINEA_BISSAU	(245),
	BRITISH_INDIAN_OCEAN_TERRITORY	(246),
	ASCENSION_ISLAND	(247),
	SEYCHELLES	(248),
	SUDAN	(249),
	RWANDA	(250),
	ETHIOPIA	(251),
	SOMALIA	(252),
	DJIBOUTI	(253),
	KENYA	(254),
	TANZANIA	(255),
	UGANDA	(256),
	BURUNDI	(257),
	MOZAMBIQUE	(258),
	ZAMBIA	(260),
	MADAGASCAR	(261),
	RUNION	(262),
	ZIMBABWE	(263),
	NAMIBIA	(264),
	MALAWI	(265),
	LESOTHO	(266),
	BOTSWANA	(267),
	SWAZILAND	(268),
	COMOROS	(269),
	SOUTH_AFRICA	(27 ),
	SAINT_HELENA	(290),
	ERITREA	(291),
	ARUBA	(297),
	FAROE_ISLANDS	(298),
	GREENLAND	(299),
	GREECE	(30 ),
	NETHERLANDS	(31 ),
	BELGIUM	(32 ),
	FRANCE	(33 ),
	SPAIN	(34 ),
	GIBRALTAR	(350),
	PORTUGAL	(351),
	LUXEMBOURG	(352),
	IRELAND	(353),
	ICELAND	(354),
	ALBANIA	(355),
	MALTA	(356),
	CYPRUS	(357),
	FINLAND	(358),
	BULGARIA	(359),
	HUNGARY	(36 ),
	LATVIA	(371),
	ESTONIA	(372),
	MOLDOVA	(373),
	ARMENIA	(374),
	BELARUS	(375),
	ANDORRA	(376),
	MONACO	(377),
	SAN_MARINO	(378),
	VATICAN_CITY	(379),
	UKRAINE	(380),
	SERBIA	(381),
	MONTENEGRO	(382),
	CROATIA	(385),
	SLOVENIA	(386),
	BOSNIA_AND_HERZEGOVINA	(387),
	MACEDONIA	(389),
	ITALY	(39 ),
	ROMANIA	(40 ),
	SWITZERLAND	(41 ),
	CZECH_REPUBLIC	(420),
	SLOVAKIA	(421),
	LIECHTENSTEIN	(423),
	AUSTRIA	(43 ),
	UNITED_KINGDOM	(44 ),
	DENMARK	(45 ),
	SWEDEN	(46 ),
	NORWAY	(47 ),
	POLAND	(48 ),
	GERMANY	(49 ),
	FALKLAND_ISLANDS	(500),
	BELIZE	(501),
	GUATEMALA	(502),
	EL_SALVADOR	(503),
	HONDURAS	(504),
	NICARAGUA	(505),
	COSTA_RICA	(506),
	PANAMA	(507),
	SAINT	(508),
	HAITI	(509),
	PERU	(51 ),
	MEXICO	(52 ),
	CUBA	(53 ),
	ARGENTINA	(54 ),
	BRAZIL	(55 ),
	CHILE	(56 ),
	COLOMBIA	(57 ),
	VENEZUELA	(58 ),
	GUADELOUPE	(590),
	BOLIVIA	(591),
	GUYANA	(592),
	ECUADOR	(593),
	FRENCH_GUIANA	(594),
	PARAGUAY	(595),
	MARTINIQUE	(596),
	SURINAME	(597),
	URUGUAY	(598),
	FORMER_NETHERLANDS_ANTILLES	(599),
	MALAYSIA	(60 ),
	AUSTRALIA	(61 ),
	INDONESIA	(62 ),
	PHILIPPINES	(63 ),
	NEW_ZEALAND	(64 ),
	SINGAPORE	(65 ),
	THAILAND	(66 ),
	EAST_TIMOR	(670),
	FORMERLY_GUAM	(671),
	AUSTRALIAN_EXTERNAL_TERRITORIES	(672),
	BRUNEI	(673),
	NAURU	(674),
	PAPUA_NEW_GUINEA	(675),
	TONGA	(676),
	SOLOMON_ISLANDS	(677),
	VANUATUS	(678),
	FIJI	(679),
	PALAU	(680),
	WALLIS_AND_FUTUNA	(681),
	COOK_ISLANDS	(682),
	NIUE	(683),
	FORMERLY_AMERICAN_SAMOA	(684),
	SAMOA	(685),
	KIRIBATI	(686),
	NEW_CALEDONIA	(687),
	TUVALU	(688),
	FRENCH_POLYNESIA	(689),
	TOKELAU	(690),
	FEDERATED_STATES_OF_MICRONESIA	(691),
	MARSHALL_ISLANDS	(692),
	RUSSIA	(7  ),
	RESERVED_FOR_SHARED_COST_SERVICES	(808),
	JAPAN	(81 ),
	SOUTH_KOREA	(82 ),
	VIETNAM	(84 ),
	NORTH_KOREA	(850),
	HONG_KONG	(852),
	MACAU	(853),
	CAMBODIA	(855),
	LAOS	(856),
	ANAC_SATELLITE_SERVICE_1	(857),
	ANAC_SATELLITE_SERVICE_2	(858),
	MAINLAND_CHINA	(86 ),
	INMARSAT_SNAC_SERVICE	(870),
	RESERVED_FOR_MARITIME_MOBILE_SERVICE_1	(875),
	RESERVED_FOR_MARITIME_MOBILE_SERVICE_2	(876),
	RESERVED_FOR_MARITIME_MOBILE_SERVICE_3	(877),
	UNIVERSAL_PERSONAL_TELECOMMUNICATIONS_SERVICES	(878),
	RESERVED_FOR_NATIONAL_NON	(879),
	BANGLADESH	(880),
	GLOBAL_MOBILE_SATELLITE_SYSTEM	(881),
	INTERNATIONAL_NETWORKS_1	(882),
	INTERNATIONAL_NETWORKS_2	(883),
	TAIWAN	(886),
	TELECOMMUNICATIONS_FOR_DISASTER_RELIEF_BY_OCHA	(888),
	TURKEY	(90 ),
	INDIA	(91 ),
	PAKISTAN	(92 ),
	AFGHANISTAN	(93 ),
	SRI_LANKA	(94 ),
	BURMA	(95 ),
	MALDIVES	(960),
	LEBANON	(961),
	JORDAN	(962),
	SYRIA	(963),
	IRAQ	(964),
	KUWAIT	(965),
	SAUDI_ARABIA	(966),
	YEMEN	(967),
	OMAN	(968),
	PALESTINIAN_TERRITORIES	(970),
	UNITED_ARAB_EMIRATES	(971),
	ISRAEL	(972),
	BAHRAIN	(973),
	QATAR	(974),
	BHUTAN	(975),
	MONGOLIA	(976),
	NEPAL	(977),
	INTERNATIONAL_PREMIUM_RATE_SERVICE	(979),
	IRAN	(98 ),
	ITPCS	(991),
	TAJIKISTAN	(992),
	TURKMENISTAN	(993),
	AZERBAIJAN	(994),
	GEORGIA	(995),
	KYRGYZSTAN	(996),
	UZBEKISTAN	(998);	
	
	private int code;
	
	
	private CountryCode (int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	
	
	public static CountryCode fromCode(JsonNode node) throws IOException {
		int value = node.asInt();

		for (CountryCode c: CountryCode.values()) {
			if (c.code == value) {
				return c;
			}
		}
		throw new IOException(String.format("Country Code - Incorrect value : %s", value));        
	}
	
	public static CountryCode fromCode(int value) {

		for (CountryCode c: CountryCode.values()) {
			if (c.code == value) {
				return c;
			}
		}
		throw new IllegalArgumentException(String.format ("Country Code - Incorrect value : %s", value));        
	}
	
	
	public static CountryCode fromMSISDN (long mobileId) {
		CountryCode c3 = getCodeThreeDigits(mobileId);
		CountryCode c2 = getCodeTwoDigits (mobileId);
		CountryCode c1 = getCodeOneDigit (mobileId);
		
		CountryCode cOther =  c2 != null ? c2 : c1;
		
		return c3 != null ? c3 : cOther;
	}
	
	
	
	private static CountryCode getCodeOneDigit (long mobileId){
		try {
			return CountryCode.fromCode(Integer.parseInt(String.valueOf(mobileId).substring(0,1)));
		} catch (IllegalArgumentException e) {
			return null;
		}
	}
	
	
	private static CountryCode getCodeTwoDigits (long mobileId) {
		try {
			return CountryCode.fromCode(Integer.parseInt(String.valueOf(mobileId).substring(0,2)));
		} catch (IllegalArgumentException e) {
			return null;
		}
	}
	
	private static CountryCode getCodeThreeDigits (long mobileId) {
		try {
			return CountryCode.fromCode(Integer.parseInt(String.valueOf(mobileId).substring(0,3)));
		} catch (IllegalArgumentException e) {
			return null;
		}	
		
	}
	
	  @Override
	  @JsonValue
	  public String toString() {
		  return this.name();
	  }

}

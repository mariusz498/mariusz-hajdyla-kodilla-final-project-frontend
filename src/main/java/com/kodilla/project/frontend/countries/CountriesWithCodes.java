package com.kodilla.project.frontend.countries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@NoArgsConstructor
@Getter
public class CountriesWithCodes {
    private Map<String, String> countriesMap = new HashMap<>();

    public CountriesWithCodes(Map<String, String> countriesMap) {
        this.countriesMap = countriesMap;
        countriesMap.put("AFG" , "Afghanistan");
        countriesMap.put("ALA" , "Åland Islands");
        countriesMap.put("ALB" , "Albania");
        countriesMap.put("DZA" , "Algeria");
        countriesMap.put("ASM" , "American Samoa");
        countriesMap.put("AND" , "Andorra");
        countriesMap.put("AGO" , "Angola");
        countriesMap.put("AIA" , "Anguilla");
        countriesMap.put("ATA" , "Antarctica");
        countriesMap.put("ATG" , "Antigua and Barbuda");
        countriesMap.put("ARG" , "Argentina");
        countriesMap.put("ARM" , "Armenia");
        countriesMap.put("ABW" , "Aruba");
        countriesMap.put("AUS" , "Australia");
        countriesMap.put("AUT" , "Austria");
        countriesMap.put("AZE" , "Azerbaijan");
        countriesMap.put("BHS" , "Bahamas");
        countriesMap.put("BHR" , "Bahrain");
        countriesMap.put("BGD" , "Bangladesh");
        countriesMap.put("BRB" , "Barbados");
        countriesMap.put("BLR" , "Belarus");
        countriesMap.put("BEL" , "Belgium");
        countriesMap.put("BLZ" , "Belize");
        countriesMap.put("BEN" , "Benin");
        countriesMap.put("BMU" , "Bermuda");
        countriesMap.put("BTN" , "Bhutan");
        countriesMap.put("BOL" , "Bolivia, Plurinational State of");
        countriesMap.put("BES" , "Bonaire, Sint Eustatius and Saba");
        countriesMap.put("BIH" , "Bosnia and Herzegovina");
        countriesMap.put("BWA" , "Botswana");
        countriesMap.put("BVT" , "Bouvet Island");
        countriesMap.put("BRA" , "Brazil");
        countriesMap.put("IOT" , "British Indian Ocean Territory");
        countriesMap.put("BRN" , "Brunei Darussalam");
        countriesMap.put("BGR" , "Bulgaria");
        countriesMap.put("BFA" , "Burkina Faso");
        countriesMap.put("BDI" , "Burundi");
        countriesMap.put("KHM" , "Cambodia");
        countriesMap.put("CMR" , "Cameroon");
        countriesMap.put("CAN" , "Canada");
        countriesMap.put("CPV" , "Cape Verde");
        countriesMap.put("CYM" , "Cayman Islands");
        countriesMap.put("CAF" , "Central African Republic");
        countriesMap.put("TCD" , "Chad");
        countriesMap.put("CHL" , "Chile");
        countriesMap.put("CHN" , "China");
        countriesMap.put("CXR" , "Christmas Island");
        countriesMap.put("CCK" , "Cocos(Keeling) Islands");
        countriesMap.put("COL" , "Colombia");
        countriesMap.put("COM" , "Comoros");
        countriesMap.put("COG" , "Congo");
        countriesMap.put("COD" , "Congo, the Democratic Republic of the");
        countriesMap.put("COK" , "Cook Islands");
        countriesMap.put("CRI" , "Costa Rica");
        countriesMap.put("CIV" , "Côte d 'Ivoire");
        countriesMap.put("HRV" , "Croatia");
        countriesMap.put("CUB" , "Cuba");
        countriesMap.put("CUW" , "Curaçao");
        countriesMap.put("CYP" , "Cyprus");
        countriesMap.put("CZE" , "Czech Republic");
        countriesMap.put("DNK" , "Denmark");
        countriesMap.put("DJI" , "Djibouti");
        countriesMap.put("DMA" , "Dominica");
        countriesMap.put("DOM" , "Dominican Republic");
        countriesMap.put("ECU" , "Ecuador");
        countriesMap.put("EGY" , "Egypt");
        countriesMap.put("SLV" , "El Salvador");
        countriesMap.put("GNQ" , "Equatorial Guinea");
        countriesMap.put("ERI" , "Eritrea");
        countriesMap.put("EST" , "Estonia");
        countriesMap.put("ETH" , "Ethiopia");
        countriesMap.put("FLK" , "Falkland Islands(Malvinas)");
        countriesMap.put("FRO" , "Faroe Islands");
        countriesMap.put("FJI" , "Fiji");
        countriesMap.put("FIN" , "Finland");
        countriesMap.put("FRA" , "France");
        countriesMap.put("GUF" , "French Guiana");
        countriesMap.put("PYF" , "French Polynesia");
        countriesMap.put("ATF" , "French Southern Territories");
        countriesMap.put("GAB" , "Gabon");
        countriesMap.put("GMB" , "Gambia");
        countriesMap.put("GEO" , "Georgia");
        countriesMap.put("DEU" , "Germany");
        countriesMap.put("GHA" , "Ghana");
        countriesMap.put("GIB" , "Gibraltar");
        countriesMap.put("GRC" , "Greece");
        countriesMap.put("GRL" , "Greenland");
        countriesMap.put("GRD" , "Grenada");
        countriesMap.put("GLP" , "Guadeloupe");
        countriesMap.put("GUM" , "Guam");
        countriesMap.put("GTM" , "Guatemala");
        countriesMap.put("GGY" , "Guernsey");
        countriesMap.put("GIN" , "Guinea");
        countriesMap.put("GNB" , "Guinea - Bissau");
        countriesMap.put("GUY" , "Guyana");
        countriesMap.put("HTI" , "Haiti");
        countriesMap.put("HMD" , "Heard Island and McDonald Islands");
        countriesMap.put("VAT" , "Holy See(Vatican City State)");
        countriesMap.put("HND" , "Honduras");
        countriesMap.put("HKG" , "Hong Kong");
        countriesMap.put("HUN" , "Hungary");
        countriesMap.put("ISL" , "Iceland");
        countriesMap.put("IND" , "India");
        countriesMap.put("IDN" , "Indonesia");
        countriesMap.put("IRN" , "Iran, Islamic Republic of");
        countriesMap.put("IRQ" , "Iraq");
        countriesMap.put("IRL" , "Ireland");
        countriesMap.put("IMN" , "Isle of Man");
        countriesMap.put("ISR" , "Israel");
        countriesMap.put("ITA" , "Italy");
        countriesMap.put("JAM" , "Jamaica");
        countriesMap.put("JPN" , "Japan");
        countriesMap.put("JEY" , "Jersey");
        countriesMap.put("JOR" , "Jordan");
        countriesMap.put("KAZ" , "Kazakhstan");
        countriesMap.put("KEN" , "Kenya");
        countriesMap.put("KIR" , "Kiribati");
        countriesMap.put("PRK" , "Korea, Democratic People's Republic of");
        countriesMap.put("KOR" , "Korea, Republic of");
        countriesMap.put("KWT" , "Kuwait");
        countriesMap.put("KGZ" , "Kyrgyzstan");
        countriesMap.put("LAO" , "Lao People 's Democratic Republic");
        countriesMap.put("LVA" , "Latvia");
        countriesMap.put("LBN" , "Lebanon");
        countriesMap.put("LSO" , "Lesotho");
        countriesMap.put("LBR" , "Liberia");
        countriesMap.put("LBY" , "Libya");
        countriesMap.put("LIE" , "Liechtenstein");
        countriesMap.put("LTU" , "Lithuania");
        countriesMap.put("LUX" , "Luxembourg");
        countriesMap.put("MAC" , "Macao");
        countriesMap.put("MKD" , "Macedonia, the former Yugoslav Republic of");
        countriesMap.put("MDG" , "Madagascar");
        countriesMap.put("MWI" , "Malawi");
        countriesMap.put("MYS" , "Malaysia");
        countriesMap.put("MDV" , "Maldives");
        countriesMap.put("MLI" , "Mali");
        countriesMap.put("MLT" , "Malta");
        countriesMap.put("MHL" , "Marshall Islands");
        countriesMap.put("MTQ" , "Martinique");
        countriesMap.put("MRT" , "Mauritania");
        countriesMap.put("MUS" , "Mauritius");
        countriesMap.put("MYT" , "Mayotte");
        countriesMap.put("MEX" , "Mexico");
        countriesMap.put("FSM" , "Micronesia, Federated States of");
        countriesMap.put("MDA" , "Moldova, Republic of");
        countriesMap.put("MCO" , "Monaco");
        countriesMap.put("MNG" , "Mongolia");
        countriesMap.put("MNE" , "Montenegro");
        countriesMap.put("MSR" , "Montserrat");
        countriesMap.put("MAR" , "Morocco");
        countriesMap.put("MOZ" , "Mozambique");
        countriesMap.put("MMR" , "Myanmar");
        countriesMap.put("NAM" , "Namibia");
        countriesMap.put("NRU" , "Nauru");
        countriesMap.put("NPL" , "Nepal");
        countriesMap.put("NLD" , "Netherlands");
        countriesMap.put("NCL" , "New Caledonia");
        countriesMap.put("NZL" , "New Zealand");
        countriesMap.put("NIC" , "Nicaragua");
        countriesMap.put("NER" , "Niger");
        countriesMap.put("NGA" , "Nigeria");
        countriesMap.put("NIU" , "Niue");
        countriesMap.put("NFK" , "Norfolk Island");
        countriesMap.put("MNP" , "Northern Mariana Islands");
        countriesMap.put("NOR" , "Norway");
        countriesMap.put("OMN" , "Oman");
        countriesMap.put("PAK" , "Pakistan");
        countriesMap.put("PLW" , "Palau");
        countriesMap.put("PSE" , "Palestinian Territory, Occupied");
        countriesMap.put("PAN" , "Panama");
        countriesMap.put("PNG" , "Papua New Guinea");
        countriesMap.put("PRY" , "Paraguay");
        countriesMap.put("PER" , "Peru");
        countriesMap.put("PHL" , "Philippines");
        countriesMap.put("PCN" , "Pitcairn");
        countriesMap.put("POL" , "Poland");
        countriesMap.put("PRT" , "Portugal");
        countriesMap.put("PRI" , "Puerto Rico");
        countriesMap.put("QAT" , "Qatar");
        countriesMap.put("REU" , "Réunion");
        countriesMap.put("ROU" , "Romania");
        countriesMap.put("RUS" , "Russian Federation");
        countriesMap.put("RWA" , "Rwanda");
        countriesMap.put("BLM" , "Saint Barthélemy");
        countriesMap.put("SHN" , "Saint Helena, Ascension and Tristan da Cunha");
        countriesMap.put("KNA" , "Saint Kitts and Nevis");
        countriesMap.put("LCA" , "Saint Lucia");
        countriesMap.put("MAF" , "Saint Martin(French part)");
        countriesMap.put("SPM" , "Saint Pierre and Miquelon");
        countriesMap.put("VCT" , "Saint Vincent and the Grenadines");
        countriesMap.put("WSM" , "Samoa");
        countriesMap.put("SMR" , "San Marino");
        countriesMap.put("STP" , "Sao Tome and Principe");
        countriesMap.put("SAU" , "Saudi Arabia");
        countriesMap.put("SEN" , "Senegal");
        countriesMap.put("SRB" , "Serbia");
        countriesMap.put("SYC" , "Seychelles");
        countriesMap.put("SLE" , "Sierra Leone");
        countriesMap.put("SGP" , "Singapore");
        countriesMap.put("SXM" , "Sint Maarten(Dutch part)");
        countriesMap.put("SVK" , "Slovakia");
        countriesMap.put("SVN" , "Slovenia");
        countriesMap.put("SLB" , "Solomon Islands");
        countriesMap.put("SOM" , "Somalia");
        countriesMap.put("ZAF" , "South Africa");
        countriesMap.put("SGS" , "South Georgia and the South Sandwich Islands");
        countriesMap.put("SSD" , "South Sudan");
        countriesMap.put("ESP" , "Spain");
        countriesMap.put("LKA" , "Sri Lanka");
        countriesMap.put("SDN" , "Sudan");
        countriesMap.put("SUR" , "Suriname");
        countriesMap.put("SJM" , "Svalbard and Jan Mayen");
        countriesMap.put("SWZ" , "Swaziland");
        countriesMap.put("SWE" , "Sweden");
        countriesMap.put("CHE" , "Switzerland");
        countriesMap.put("SYR" , "Syrian Arab Republic");
        countriesMap.put("TWN" , "Taiwan, Province of China");
        countriesMap.put("TJK" , "Tajikistan");
        countriesMap.put("TZA" , "Tanzania, United Republic of");
        countriesMap.put("THA" , "Thailand");
        countriesMap.put("TLS" , "Timor - Leste");
        countriesMap.put("TGO" , "Togo");
        countriesMap.put("TKL" , "Tokelau");
        countriesMap.put("TON" , "Tonga");
        countriesMap.put("TTO" , "Trinidad and Tobago");
        countriesMap.put("TUN" , "Tunisia");
        countriesMap.put("TUR" , "Turkey");
        countriesMap.put("TKM" , "Turkmenistan");
        countriesMap.put("TCA" , "Turks and Caicos Islands");
        countriesMap.put("TUV" , "Tuvalu");
        countriesMap.put("UGA" , "Uganda");
        countriesMap.put("UKR" , "Ukraine");
        countriesMap.put("ARE" , "United Arab Emirates");
        countriesMap.put("GBR" , "United Kingdom");
        countriesMap.put("USA" , "United States");
        countriesMap.put("UMI" , "United States Minor Outlying Islands");
        countriesMap.put("URY" , "Uruguay");
        countriesMap.put("UZB" , "Uzbekistan");
        countriesMap.put("VUT" , "Vanuatu");
        countriesMap.put("VEN" , "Venezuela, Bolivarian Republic of");
        countriesMap.put("VNM" , "Viet Nam");
        countriesMap.put("VGB" , "Virgin Islands, British");
        countriesMap.put("VIR" , "Virgin Islands, U.S.");
        countriesMap.put("WLF" , "Wallis and Futuna");
        countriesMap.put("ESH" , "Western Sahara");
        countriesMap.put("YEM" , "Yemen");
        countriesMap.put("ZMB" , "Zambia");
        countriesMap.put("ZWE" , "Zimbabwe");
    }
}

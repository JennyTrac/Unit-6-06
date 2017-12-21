/* created by jenny trac
created on dec 19 2017
uses enums to make sure user inputs valid street type and province
found how to check enums at https://stackoverflow.com/questions/4936819/java-check-if-enum-contains-a-given-strin=8 */

import java.util.Scanner;

public class EmergencyAddress {
   
    enum provinces {
        BC, AB, SK, MB, ON, QC, NS, NC, NL, PE, YT, NT, NU }
   
    enum StreetTypes {
        St, Dr, Cir, Rd, Ave }
   
    public static String[] MailingAddressObject (String FirstN, String LastN, String HouseN, String StreetN, String StreetT, String City, String Prov, String Post) {
        String [] MailAddressInfo = {FirstN, LastN, HouseN, StreetN, StreetT, City, Prov, Post};
        return MailAddressInfo;
    }
    
    public static boolean CheckProvince(String CheckProv) {
        for (provinces ProvOptions: provinces.values()) {
            if (ProvOptions.name().equals(CheckProv)) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean CheckStreetType(String CheckStreetT) {
        for (StreetTypes StreetTOptions: StreetTypes.values()) {
            if (StreetTOptions.name().equals(CheckStreetT)) {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        // input
        System.out.println("Format your emergency address:");
        Scanner problem_FN = new Scanner(System.in);
        Scanner problem_LN = new Scanner(System.in);
        Scanner problem_HN = new Scanner(System.in);
        Scanner problem_SN = new Scanner(System.in);
        Scanner problem_ST = new Scanner(System.in);
        Scanner problem_CT = new Scanner(System.in);
        Scanner problem_PR = new Scanner(System.in);
        Scanner problem_PO = new Scanner(System.in);
        
        System.out.println("Enter your first name:");
        String FirstName = (problem_FN.nextLine());
        System.out.println("Enter your last name:");
        String LastName = (problem_LN.nextLine());
        System.out.println("Enter your house number:");
        String HouseNumber = (problem_HN.nextLine());
        System.out.println("Enter your street name:");
        String StreetName = (problem_SN.nextLine());
        System.out.println("Enter your street type:");
        String StreetType = (problem_ST.nextLine());
        System.out.println("Enter your city name:");
        String CityName = (problem_CT.nextLine());
        System.out.println("Enter your province:");
        String Province = (problem_PR.nextLine());
        System.out.println("Enter your postal code:");
        String PostalCode = (problem_PO.nextLine());
        
        boolean ProvinceCheck = EmergencyAddress.CheckProvince(Province);
        boolean StreetTypeCheck = EmergencyAddress.CheckStreetType(StreetType);
        
        if (ProvinceCheck == false && StreetTypeCheck == false) {
            System.out.println("Not a valid province and not a valid street type.");
            }
        else if (ProvinceCheck == false && StreetTypeCheck == true) {
            System.out.println("Not a valid province.");
            }
        else if (ProvinceCheck == true && StreetTypeCheck == false) {
            System.out.println("Not a valid street type.");
            }
        else if (ProvinceCheck == true && StreetTypeCheck == true) {
            String[] MailingAddressInfo = EmergencyAddress.MailingAddressObject (
                FirstName,
                LastName,
                HouseNumber,
                StreetName,
                StreetType,
                CityName,
                Province,
                PostalCode
            );
            System.out.println("Your emergency address:");
            System.out.println(MailingAddressInfo[2] + " " + MailingAddressInfo[3] + " " + MailingAddressInfo [4]);
            }
    }
}

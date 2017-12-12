# created by jenny trac
# created on dec 5 2017
# program puts a mailing address into a structure and formats it

from enum import Enum

# variables and constants
Provinces = Enum('BC', 'AB', 'SK', 'MB', 'ON', 'QC', 'NB', 'NL', 'NS', 'PE', 'YT', 'NT', 'NU')
Street_types = Enum('Dr.', 'Ave.', 'Rd.', 'Cir.', 'St.')

class MailingAddress():
    def __init__(self, first_name, last_name, house_number, street_name, street_type, city_name, province, postal_code):
        self.first_name = first_name
        self.last_name = last_name
        self.house_number = house_number
        self.street_name = street_name
        self.street_type = street_type
        self.city_name = city_name
        self.province = province
        self.postal_code = postal_code
    
    def emergency_address(self):
        # returns emergency address
        
        self.emrg_address = self.house_number + " " + self.street_name + " " + self.street_type
        
        return self.emrg_address

# input
print("Format your emergency address:")
print("First name:")
f_name = raw_input()
print("Last name:")
l_name = raw_input()
print("House number:")
h_number = raw_input()
print("Street name:")
s_name = raw_input()
print("Street type:")
s_type = raw_input()
print("City:")
city = raw_input()
print("Province:")
prov = raw_input()
print("Postal code:")
postal = raw_input()

# process
mailing_address = MailingAddress(f_name, l_name, h_number, s_name, s_type, city, prov, postal)
print(" ")
if (mailing_address.province in Provinces) and (mailing_address.street_type in Street_types):
    # output
    print("Your emergency address:")
    print(mailing_address.emergency_address())
else:
    if (mailing_address.province in Provinces):
        print("Not a valid street type.")
    elif (mailing_address.street_type in Street_types):
        print("Not a valid province.")
    else:
        print("Not a valid province and not a valid street type.")

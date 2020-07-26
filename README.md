## This Repository contains the Automation Framework for Assignment1.
 ### Design Patter Used: PageObject Model
 I have Page Object Model in which each page has corresponding java class.
 ### Test Cases
 1. To find Broken Images on Deposit Page (present in HomePageTest.java)  
    Approach Used -  
    Earlier, I have used HTTPClient library but getting error - SSLException: Certificate name doesn't match with hostname.  
    Later, I switched to different approach which checks the whether the naturalWidth of image is > 0. If it is, then it is valid, otherwise not.  
    
 2. Used DataProvider to verify Minimum and Maximum Amount value Error messages. Test Case - 9999 for Minimum and 100001 for Maximum.  
     
 3. Used DataProvider to verify Total Interest Amount. Test cases - 11000 and 50000.  
    Note: However the logic of 7.26 % of Amount doesn't match with GUI value.  
    
    For ex. 7.26% 11000 = 798.6, however on web page it's showing 852.  
    I kept the logic as it is. Hence these two TCs are failing
    

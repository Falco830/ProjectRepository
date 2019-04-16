'''
Created on Mar 29, 2019

@author: Alec
'''

from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.by import By

def ready(wait, driver):
    wait.until(EC.presence_of_element_located((By.CLASS_NAME, "game-chat-bar")))
    #driver.find_element_by_xpath("//*[@type='text']").send_keys("TestBot")
    
    #print(driver.find_element_by_xpath("//*[@class='game-accordion']").is_enabled())
    #print(driver.find_element_by_xpath("//*[@class='game-accordion']/div[2]").is_enabled())
    #print(driver.find_element_by_xpath("//*[@class='game-accordion']/div[2]/div").is_enabled())
    #print(driver.find_element_by_xpath("//*[@class='game-accordion']/div[2]/div/div").is_enabled())
    #print(driver.find_element_by_xpath("//*[@class='game-accordion']/div[2]/div/div/div").is_enabled())
    #print(driver.find_element_by_xpath("//*[@class='game-accordion']/div[2]//div/div/div/button[1]").is_enabled())
    #print(driver.find_element_by_xpath("//*[@class='game-accordion']/div[2]//div/div/div/button[2]").is_enabled())
    #print(driver.find_element_by_xpath("//*[@class='game-accordion']/div[2]//div/div/div/button[3]").is_enabled())
    #driver.find_element_by_xpath("//*[@class='game-accordion']/div[2]//div/div/div/button[3]").click()
    if driver.find_elements(By.XPATH, "//*[@class='game-accordion']/div[2]/div/div/div/button[3]"):
        return driver.find_element_by_xpath("//*[@class='game-accordion']/div[2]/div/div/div/button[3]").is_enabled()
    else: 
        return False
'''
Created on Mar 28, 2019

@author: Alec
'''
from selenium import webdriver
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
user = ""
pwd = ""

def createNewWorld(wait, driver):
    wait.until(EC.presence_of_element_located((By.CLASS_NAME, "flex-1")))
    driver.find_element_by_xpath("//*[@class='flex']//*[@type='text']").clear()
    driver.find_element_by_xpath("//*[@class='flex']//*[@type='text']").send_keys("Casual Mafia")
    #driver.find_element_by_xpath("//*[@class='row']//*[@class='checkbox']").click()
    driver.find_element_by_xpath("//*[@type='submit']//*[@class='button-contents']").click()

    return

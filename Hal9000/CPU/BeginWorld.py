'''
Created on Mar 29, 2019

@author: Alec
'''
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.by import By

def start(wait, driver):
    #wait.until(EC.presence_of_element_located((By.CLASS_NAME, "game-action-pane")))
    wait.until(EC.visibility_of_element_located((By.XPATH, "//*[@class='game-accordion']/div[2]//div/div/div/button[3]")))

    #driver.find_element_by_xpath("//*[@type='text']").send_keys("TestBot")
    print(driver.find_element_by_xpath("//*[@class='game-accordion']/div[2]//div/div/div/button[3]").is_enabled())
    driver.implicitly_wait(1)
    if driver.find_elements(By.XPATH, "//*[@class='game-accordion']/div[2]/div/div/div/button[3]"):
        driver.implicitly_wait(3)
        driver.find_element_by_xpath("//*[@class='game-accordion']/div[2]/div/div/div/button[3]").click()
    #driver.execute_script("document.querySelectorAll('label.boxed')[1].click()")

    return
    
    
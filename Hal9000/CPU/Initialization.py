'''
Created on Mar 28, 2019

@author: Alec
'''
from selenium import webdriver
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from CPU import CreatingNewWorld
from CPU import Standby
from CPU import BeginWorld
user = ""
pwd = ""
driver = webdriver.Chrome()
driver.get("https://mafia.gg")
driver.set_window_size(1920, 1080)
wait = WebDriverWait(driver, 10)
wait.until(EC.presence_of_element_located((By.CLASS_NAME, "main")))
assert "Mafia.gg" in driver.title
elem = driver.find_element_by_xpath("//*[@href='/login']").click()
wait.until(EC.presence_of_element_located((By.CLASS_NAME, "account-input")))
driver.find_element_by_xpath("//*[@type='text']").send_keys("Falco830")
driver.find_element_by_xpath("//*[@type='password']").send_keys("legolas123")
driver.find_element_by_xpath("//*[@type='submit']").click()

driver2 = webdriver.Chrome()
driver2.get("https://mafia.gg")
driver2.set_window_size(1920, 1080)
wait2 = WebDriverWait(driver2, 10)
wait2.until(EC.presence_of_element_located((By.CLASS_NAME, "main")))
assert "Mafia.gg" in driver2.title
elem = driver2.find_element_by_xpath("//*[@href='/login']").click()
wait2.until(EC.presence_of_element_located((By.CLASS_NAME, "account-input")))
driver2.find_element_by_xpath("//*[@type='text']").send_keys("Falco830")
driver2.find_element_by_xpath("//*[@type='password']").send_keys("legolas123")
driver2.find_element_by_xpath("//*[@type='submit']").click()

gamesPlayed = 0

while True :     
    CreatingNewWorld.createNewWorld(wait, driver)
    wait.until(EC.presence_of_element_located((By.CLASS_NAME, "game-center")))
    menuPath = driver.find_element_by_xpath("/html/body/div[1]/main/div/div[2]/div[1]/div[3]")
    price_content = menuPath.get_attribute('innerHTML')
    print(price_content.strip())
    driver2.find_element_by_xpath("//*[@type='text']").send_keys(driver.current_url)
    driver2.implicitly_wait(1)
    if driver2.find_elements(By.XPATH, "/html/body/div[1]/main/div/div[2]/div[3]/form/button"):
        driver2.find_element_by_xpath("/html/body/div[1]/main/div/div[2]/div[3]/form/button").click()
    driver2.find_element_by_xpath("/html/body/div[1]/header/div/h1/a").click()
    
    while (price_content.strip() == "Pre-game"):
        if Standby.ready(wait, driver):
            BeginWorld.start(wait, driver)     
            driver.implicitly_wait(1)
            #wait.until(EC.presence_of_element_located((By.CLASS_NAME, "game-center")))
            if driver.find_elements(By.XPATH, "/html/body/div[1]/main/div/div[2]/div[1]/div[5]/button"):
                menuPath = driver.find_element_by_xpath("/html/body/div[1]/main/div/div[2]/div[1]/div[5]/button")
            price_content = menuPath.get_attribute('innerHTML')
            print(price_content.strip())
    while (price_content.strip() != "Post-game"):
        menuPath = driver.find_element_by_xpath("/html/body/div[1]/main/div/div[2]/div[1]/div[5]/button")
        price_content = menuPath.get_attribute('innerHTML')
        #print(price_content.strip())
        #print("Not in Post Game")       
    gamesPlayed += 1
    print("games played: ", gamesPlayed)
    CreatingNewWorld.createNewWorld(wait2, driver2)
    wait2.until(EC.presence_of_element_located((By.CLASS_NAME, "game-center")))
    menuPath = driver2.find_element_by_xpath("/html/body/div[1]/main/div/div[2]/div[1]/div[3]")
    price_content = menuPath.get_attribute('innerHTML')
    print(price_content.strip())
    driver.find_element_by_xpath("//*[@type='text']").send_keys(driver2.current_url)
    driver.find_element_by_xpath("/html/body/div[1]/main/div/div[2]/div[3]/form/button").click()
    driver.find_element_by_xpath("/html/body/div[1]/header/div/h1/a").click()
    
    while (price_content.strip() == "Pre-game"):
        if Standby.ready(wait2, driver2):
            BeginWorld.start(wait2, driver2)     
            driver2.implicitly_wait(1)
            #wait.until(EC.presence_of_element_located((By.CLASS_NAME, "game-center")))        
            if driver2.find_elements(By.XPATH, "/html/body/div[1]/main/div/div[2]/div[1]/div[5]/button"):
                menuPath = driver2.find_element_by_xpath("/html/body/div[1]/main/div/div[2]/div[1]/div[5]/button")
            price_content = menuPath.get_attribute('innerHTML')
            print(price_content.strip())
    while(price_content.strip() != "Post-game"):
        menuPath = driver2.find_element_by_xpath("/html/body/div[1]/main/div/div[2]/div[1]/div[5]/button")
        price_content = menuPath.get_attribute('innerHTML')
        #print(price_content.strip())
        #print("Not in Post Game")     
    gamesPlayed += 1
    print("games played: ", gamesPlayed)
    
print("Done")

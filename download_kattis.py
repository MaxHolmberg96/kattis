import requests
import getpass
from bs4 import BeautifulSoup as BS

#headers for login
header = {
    "Host": "open.kattis.com",
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:64.0) Gecko/20100101 Firefox/64.0",
    "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
    "Accept-Language": "en-US,en;q=0.5",
    "Accept-Encoding": "gzip, deflate, br",
    "Connection": "keep-alive",
    "Upgrade-Insecure-Requests": "1",
    "DNT" : "1"
}

#first visit: https://open.kattis.com/login/email
url = "https://open.kattis.com/login/email"
session = requests.session()
response = session.get(url)

soup = BS(response.text, "lxml")
csrf_token = soup.find('input', {"name": "csrf_token"})["value"]
username = input("username:")
password = getpass.getpass()
response = session.post("https://open.kattis.com/login/email", data={"csrf_token" : csrf_token, "user" : username, "password" : password, "submit" : "Submit"})
#now logged in

page = session.get("https://open.kattis.com/problems?show_solved=on&show_tried=off&show_untried=off")
#search through all the 50 problems


# for each problem in str_problems, visit https://open.kattis.com/users/max-holmberg/submissions/[problem_name]
has_next = 1
while has_next:
    page_soup = BS(page.text, "lxml")
    #get all the problems on the page
    problems = page_soup.find_all("tr", {"class" : "solved"})
    str_problems = []
    for problem in problems:
        a = problem.find("a")["href"]
        problem_name = a[a.rfind("/") + 1 :]
        str_problems.append(problem_name)

    for problem in str_problems:
        response = session.get("https://open.kattis.com/users/max-holmberg/submissions/" + problem)
        soup = BS(response.text, "lxml")
        all_submissions = soup.find_all("td", {"class" : "accepted"})
        submission_id = all_submissions[0].find_parent("tr").find("td", {"class" : "submission_id"}).find("a").text
        response = session.get("https://open.kattis.com/submissions/" + str(submission_id))
        soup = BS(response.text, "lxml")
        file_name = soup.find("div", {"class" : "submission_code_container"})["data-filename"]
        response = session.get("https://open.kattis.com/submissions/" + str(submission_id) + "/source/" + file_name)
        file_type = file_name[file_name.index(".") + 1 :]
        print problem + "." + file_type
        open("".join([problem, ".", file_type]), "w+").write(response.text.encode("utf8"))
    try:
        #idk if this works, BUT it crashes when its on the last problem so the try except works :)
        if page_soup.find("a", {"id" : "problem_list_next"})["class"] == "disabled":
            has_next = 0
        else:
            page = session.get("https://open.kattis.com" + page_soup.find("a", {"id" : "problem_list_next"})["href"])
    except:
        exit(0)
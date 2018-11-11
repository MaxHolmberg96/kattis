// Example program
#include <iostream>
#include <string>
using namespace std;
int main()
{
  std::ios_base::sync_with_stdio(false);
  string pattern;
  string text;
  while(getline(cin, pattern)){
      getline(cin, text);
      size_t pos;
      pos = text.find(pattern, 0);
      while(pos != string::npos){
          cout << pos << " ";
          pos = text.find(pattern, pos+1);
      }
      cout << endl;
  }
}

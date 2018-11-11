// Example program
#include <iostream>
#include <string>
using namespace std;
int main()
{
  std::ios_base::sync_with_stdio(false);
  string pattern;
  string text;
  string c;
  while(getline(cin, c)){
      int k = stoi(c);
      string pattern[k];
      for(int i = 0; i < k; i++)
        getline(cin, pattern[i]);
      getline(cin, text);
      for(int i = 0; i < k; i++){
          size_t pos;
          pos = text.find(pattern[i], 0);
          while(pos != string::npos){
              cout << pos << " ";
              pos = text.find(pattern[i], pos+1);
          }
          cout << endl;
      }
      
  }
}

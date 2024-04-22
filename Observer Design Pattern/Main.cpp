// Observer Design Pattern

// YT link -> https://youtu.be/X_qgljbTu9s?feature=shared

// The Observer Pattern is a behavioral software design pattern that defines a one-to-many dependency between objects. It allows an object (called the subject) to notify other objects (called observers) about any changes in its state

#include <iostream>
#include <vector>
#include <string>
using namespace std;

// Interface for observers
class Observer
{
public:
  virtual void update(string &msg) = 0;
};

// Concrete observer class 1
class User1 : public Observer
{
public:
  void update(string &msg) override
  {
    cout << "User 1: " << msg << endl;
  }
};

// Concrete observer class 2
class User2 : public Observer
{
public:
  void update(string &msg) override
  {
    cout << "User 2: " << msg << endl;
  }
};

// Concrete observer class 3
class User3 : public Observer
{
public:
  void update(string &msg) override
  {
    cout << "User 3: " << msg << endl;
  }
};

// Interface for subjects
class Subject
{
public:
  virtual void registerObserver(Observer *o) = 0;
  virtual

      void
      unregisterObserver(Observer *o) = 0;
  virtual

      void
      notifyObservers(string &msg) = 0;
};

// Subject class for Youtube Channel 1
class YoutubeChannel1 : public Subject
{
private:
  vector<Observer *> observers;

public:
  void registerObserver(Observer *o) override
  {
    observers.push_back(o);
  }

  void unregisterObserver(Observer *o) override
  {
    for (auto it = observers.begin(); it != observers.end(); ++it)
    {
      if (*it == o)
      {
        observers.erase(it);
        return;
      }
    }
  }

  void notifyObservers(string &msg) 
  {
    for (auto observer : observers)
    {
      observer->update(msg);
    }
  }

  void newVideoAdded(string &msg)
  {
    notifyObservers(msg);
  }
};

// Subject class for Youtube Channel 2 (similar structure to YoutubeChannel1)
class YoutubeChannel2 : public Subject
{
private:
  vector<Observer *> observers;

public:
  void registerObserver(Observer *o) override
  {
    observers.push_back(o);
  }

  void unregisterObserver(Observer *o) override
  {
    for (auto it = observers.begin(); it != observers.end(); ++it)
    {
      if (*it == o)
      {
        observers.erase(it);
        return;
      }
    }
  }

  void notifyObservers(string &msg) 
  {
    for (auto observer : observers)
    {
      observer->update(msg);
    }
  }

  void newVideoAdded(string &msg)
  {
    notifyObservers(msg);
  }
};

int main()
{
  YoutubeChannel1 youtubeChannel1;
  YoutubeChannel2 youtubeChannel2;

  User1 user1;
  User2 user2;
  User3 user3;

  youtubeChannel1.registerObserver(&user1);
  youtubeChannel1.registerObserver(&user2);

  youtubeChannel2.registerObserver(&user3);
  youtubeChannel2.registerObserver(&user2);

  string s1 = "Video 1";
  string s2 = "Video 2";
  youtubeChannel1.newVideoAdded(s1);
  youtubeChannel2.newVideoAdded(s2);

  return 0;
}

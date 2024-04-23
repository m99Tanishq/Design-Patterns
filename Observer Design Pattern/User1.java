// Observer Design Pattern

// YT link -> https://youtu.be/X_qgljbTu9s?feature=shared

// The Observer Pattern is a behavioral software design pattern that defines a one-to-many dependency between objects. It allows an object (called the subject) to notify other objects (called observers) about any changes in its state

import java.util.ArrayList;

public
interface Observer
{
  void update(String msg);
}

public
class User1 implements Observer
{
  @Override public void update(String msg)
  {
    System.out.println("User 1" + msg);
  }
}

public class User2 implements Observer
{
  @Override public void update(String msg)
  {
    System.out.println("User 1" + msg);
  }
}

public class User3 implements Observer
{
  @Override public void update(String msg)
  {
    System.out.println("User 1" + msg);
  }
}

public interface Subject
{
  void registerObserver(Observer o);

  void unregisterObserver(Observer o);

  void notifyObserver(String msg);
}

public
class YoutubeChannel1 implements Subjects
{

  ArrayList<Observer> observerList;

  YoutubeChannel1()
  {
    observerList = new ArrayList<Observer>();
  }

  @Override public void registerObserver(Observer o)
  {
    observerList.add(o);
  }

  @Override public void unregisterObserver(Observer o)
  {
    int index = observerList.indexOf(o);
    if (index >= 0)
    {
      observerList.remove(index);
    }
  }

  @Override public void notifyObserver(String msg)
  {
    for (Observer o : observerList)
    {
      o.update(msg);
    }
  }

  void newVideoAdded(String msg)
  {
    notifyObserver(msg);
  }
}

public class YoutubeChannel2 implements Subjects
{

  ArrayList<Observer> observerList;

  YoutubeChannel1()
  {
    observerList = new ArrayList<Observer>();
  }

  @Override public void registerObserver(Observer o)
  {
    observerList.add(o);
  }

  @Override public void unregisterObserver(Observer o)
  {
    int index = observerList.indexOf(o);
    if (index >= 0)
    {
      observerList.remove(index);
    }
  }

  @Override public void notifyObserver(String msg)
  {
    for (Observer o : observerList)
    {
      o.update(msg);
    }
  }

  void newVideoAdded(String msg)
  {
    notifyObserver(msg);
  }
}

public class Main
{
public
  static void main(String[] s)
  {

    YoutubeChannel1 youtubeChannel1 = new YoutubeChannel1();
    YoutubeChannel2 youtubeChannel2 = new YoutubeChannel2();

    User1 user1 = new User1();
    User1 user2 = new User2();
    User1 user3 = new User3();

    youtubeChannel1.registerObserver(user1);
    youtubeChannel1.registerObserver(user2);

    youtubeChannel2.registerObserver(user3);
    youtubeChannel2.registerObserver(user2);

    youtubeChannel1.newVideoAdded("Video 1");
    youtubeChannel2.newVideoAdded("Video 2");
  }
}



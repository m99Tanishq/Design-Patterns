// Decorator Design Pattern

// The Decorator Design Pattern is a structural pattern that allows to add new behavior to an object dynamically, without altering its structure.

#include <iostream>
#include <string>
using namespace std;

// Abstract base class for Ice Cream
class IceCream
{
public:
  virtual string

  getDescription() const = 0;
  virtual

      int
      cost() const = 0;
};

// Concrete Ice Cream flavors
class ChocolateIceCream : public IceCream
{
public:
  string getDescription() const override
  {
    return "Chocolate";
  }

  int cost() const override
  {
    return 70;
  }
};

class VanillaIceCream : public IceCream
{
public:
  string getDescription() const override
  {
    return "Vanilla";
  }

  int cost() const override
  {
    return 100;
  }
};

// Abstract decorator class
class IceCreamDecorator : public IceCream
{
private:
  IceCream *iceCream;

protected:
  IceCreamDecorator(IceCream *iceCream) : iceCream(iceCream) {}

public:
  virtual string getDescription() const override
  {
    return iceCream->getDescription();
  }

  virtual

      int
      cost() const override
  {
    return iceCream->cost();
  }
};

// Decorators for adding toppings
class RainbowSprinkleDecorator : public IceCreamDecorator
{
public:
  RainbowSprinkleDecorator(IceCream *iceCream) : IceCreamDecorator(iceCream) {}

  string getDescription() const override
  {
    return IceCreamDecorator::getDescription() + " with Rainbow Sprinkles";
  }

  int cost() const override
  {
    return IceCreamDecorator::cost() + 30;
  }
};

class WippedCreamDecorator : public IceCreamDecorator
{
public:
  WippedCreamDecorator(IceCream *iceCream) : IceCreamDecorator(iceCream) {}

  string getDescription() const override
  {
    return IceCreamDecorator::getDescription() + " with Whipped Cream";
  }

  int cost() const override
  {
    return IceCreamDecorator::cost() + 30;
  }
};

int main()
{
  IceCream *iceCream = new ChocolateIceCream();

  // Decorate the ice cream with Rainbow Sprinkles and then Whipped Cream
  iceCream = new RainbowSprinkleDecorator(iceCream);
  iceCream = new WippedCreamDecorator(iceCream);

  cout << iceCream->getDescription() << " costs " << iceCream->cost() << endl;

  // Clean up memory
  delete iceCream;

  return 0;
}

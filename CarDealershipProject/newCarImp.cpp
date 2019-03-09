#include "stdafx.h"
#include <vector>
#include <string>
#include <iostream>
#include <stdlib.h>
#include "car.h"
#include "newCar.h"

using namespace std;

void newCar::setWarranty(string _warranty)
{
	warranty = _warranty;
}

string newCar::getWarranty() const
{
	return warranty;
}

void newCar::setCar(string _make, string _model, float _price, string _vin, string _cat, string _warranty)
{
	car::setCar(_make, _model, _price, _vin, _cat);
	warranty = _warranty;
}

newCar::newCar()
{
	warranty = "";
}

newCar::newCar(string _make, string _model, float _price, string _vin, string _cat, string _warranty)
	: car(_make, _model, _price, _vin, _cat)
{
	warranty = _warranty;
}

void newCar::print()
{
	cout << "Make: " << getMake() << endl;
	cout << "Model: " << getModel() << endl;
	cout << "Price: " << getPrice() << endl;
	cout << "VIN: " << getVin() << endl;
	cout << "Category: " << getCat() << endl;
	cout << "Warranty: " << getWarranty() << endl;
	cout << endl;
}
#include "stdafx.h"
#include <vector>
#include <string>
#include <iostream>
#include <stdlib.h>
#include "car.h"
#include "usedCar.h"

using namespace std;

void usedCar::setMileage(int _mileage)
{
	mileage = _mileage;
}

int usedCar::getMileage() const
{
	return mileage;
}

usedCar::usedCar()
{
	mileage = 0;
}

usedCar::usedCar(string _make, string _model, float _price, string _vin, string _cat, int _mileage)
	: car(_make, _model, _price, _vin, _cat)
{
	mileage = _mileage;
}

void usedCar::setCar(string _make, string _model, float _price, string _vin, string _cat, int _mileage)
{
	car::setCar(_make, _model, _price, _vin, _cat);
	mileage = _mileage;
}

void usedCar::print()
{
	cout << "Make: " << getMake() << endl;
	cout << "Model: " << getModel() << endl;
	cout << "Price: " << getPrice() << endl;
	cout << "VIN: " << getVin() << endl;
	cout << "Category: " << getCat() << endl;
	cout << "Mileage: " << getMileage() << endl;
	cout << endl;
}
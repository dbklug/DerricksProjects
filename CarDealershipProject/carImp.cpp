#include "stdafx.h"
#include <vector>
#include <string>
#include <iostream>
#include <stdlib.h>
#include "car.h"

using namespace std;

car::car()
{
	make = " ";
	model = " ";
	price = 0.0;
	vin = " ";
	cat = " ";
}

car::car(string _make, string _model, float _price, string _vin, string _cat)
{
	make = _make;
	model = _model;
	price = _price;
	vin = _vin;
	cat = _cat;
}

void car::setCar(string _make, string _model, float _price, string _vin, string _cat)
{
	make = _make;
	model = _model;
	price = _price;
	vin = _vin;
	cat = _cat;
}

string car::getMake() const
{
	return make;
}

string car::getModel() const
{
	return model;
}

float car::getPrice() const
{
	return price;
}

string car::getVin() const
{
	return vin;
}

string car::getCat() const
{
	return cat;
}
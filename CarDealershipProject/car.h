#pragma once
#include "stdafx.h"
#include <vector>
#include <string>
#include <iostream>
#include <stdlib.h>

using namespace std;

class car {
public:
	void setCar(string, string, float, string, string);
	string getMake() const;
	string getModel() const;
	float getPrice() const;
	string getVin() const;
	string getCat() const;
	car();
	car(string, string, float, string, string);

private:
	string make;
	string model;
	float price;
	string vin;
	string cat;
};

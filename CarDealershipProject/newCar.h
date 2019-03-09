#pragma once
#include "stdafx.h"
#include <vector>
#include <string>
#include <iostream>
#include <stdlib.h>
#include "car.h"

using namespace std;

class newCar : public car {
public:
	void setWarranty(string);
	string getWarranty() const;
	void print();
	void setCar(string, string, float, string, string, string);
	newCar();
	newCar(string, string, float, string, string, string);

private:
	string warranty;
};
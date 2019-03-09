#pragma once
#include "stdafx.h"
#include <vector>
#include <string>
#include <iostream>
#include <stdlib.h>
#include "car.h"

using namespace std;

class usedCar : public car {
public:
	void setMileage(int);
	int getMileage() const;
	void print();
	void setCar(string, string, float, string, string, int);
	usedCar();
	usedCar(string, string, float, string, string, int);

private:
	int mileage;
};
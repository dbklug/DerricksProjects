#include "stdafx.h"
#include <vector>
#include <string>
#include <iostream>
#include <stdlib.h>
#include "car.h"
#include "newCar.h"
#include "usedCar.h"

using namespace std;

///////////////////MENU//////////////////////

void showMenu() {
	cout << "KLUG CHEVERLET / GMC\nDEALERSHIP INVENTORY\n\n1. Search Inventory\n2. Sell/Lease Car\n"
		<< "3. Return a Leased Car\n4. Add a car to Inventory\n"
		<< "5. Show Inventory\n6. Exit\nPlease enter a choice: ";
}

////////////////////MAIN//////////////////////

void NewCarInventory(vector<newCar>& newNewCar);
void UsedCarInventory(vector<usedCar>&newUsedCar);
void searchInventory(vector<newCar>& newNewCar, vector<usedCar>&newUsedCar);
void sell_lease(vector<newCar>& newNewCar, vector<usedCar>&newUsedCar);
void returnLease(vector<newCar>& newNewCar, vector<usedCar>&newUsedCar);
void addCar(vector<newCar>&newNewCar, vector<usedCar>&newUsedCar);
void getInventory(vector<newCar>&newNewCar, vector<usedCar>&newUsedCar);

int main() {
	int input;
	vector<newCar>myNewCar;
	vector<usedCar>myUsedCar;

	NewCarInventory(myNewCar);
	UsedCarInventory(myUsedCar);

	while (true) {
		showMenu();
		cin >> input;
		system("cls");
		switch (input) {
		case 1: searchInventory(myNewCar, myUsedCar);
			break;
		case 2: sell_lease(myNewCar, myUsedCar);
			break;
		case 3: returnLease(myNewCar, myUsedCar);
			break;
		case 4: addCar(myNewCar, myUsedCar);
			break;
		case 5: getInventory(myNewCar, myUsedCar);
			break;
		case 6: return 0;
			break;
		default:  cout << endl;
		}
	}

	return 0;
}
//Hard coded new car inventory
void NewCarInventory(vector<newCar>& newNewCar)
{
	newCar a, b, c, d, e, f, g, h, i, j;
	a.setCar("Chevy", "Cruze", 22000.00, "2HGES16545H626602", "new", "Edmunds");
	newNewCar.push_back(a);
	b.setCar("Chevy", "Malibu", 35000.00, "1G6DA5E55C0128032", "new", "Edmunds");
	newNewCar.push_back(b);
	c.setCar("Chevy", "Impalla", 40000.00, "3GNAL3EK6DS623104", "new", "Easy Care");
	newNewCar.push_back(c);
	d.setCar("Chevy", "Cruze", 28000.00, "1HGCP2F84BA009526", "new", "Toco");
	newNewCar.push_back(d);
	e.setCar("Chevy", "Camero", 65000.00, "5GZCZ53457S849682", "new", "Auto Assure");
	newNewCar.push_back(e);
	f.setCar("GMC", "Acadia", 83000.00, "2G1FB1EDXB9105278", "new", "Auto Assure");
	newNewCar.push_back(f);
	g.setCar("GMC", "Sierra", 50000.00, "JTJJM7FX2D5061006", "new", "Toco");
	newNewCar.push_back(g);
	h.setCar("GMC", "Yukon", 80000.00, "SALPV1641YA442218", "new", "Easy Care");
	newNewCar.push_back(h);
	i.setCar("GMC", "Terrain", 48000.00, "3FAHP0JAXCR399046", "new", "Toco");
	newNewCar.push_back(i);
	j.setCar("GMC", "Canyon", 45000.00, "3D7KS19D46G283091", "new", "Edmunds");
	newNewCar.push_back(j);
}
//hard coded used car inventory
void UsedCarInventory(vector<usedCar>& newUsedCar)
{
	usedCar k, l, m, n, o, p, q, r, s, t;
	k.setCar("Chevy", "Cruze", 8000.00, "JNKCN54E04M803941", "used", 75000);
	newUsedCar.push_back(k);
	l.setCar("Chevy", "Cruze", 12000.00, "4V4WDBGG3TN713547", "used", 55000);
	newUsedCar.push_back(l);
	m.setCar("Chevy", "Camero", 28000.00, "4M2DU86W33ZJ29456", "used", 152000);
	newUsedCar.push_back(m);
	n.setCar("Chevy", "Trax", 16000.00, "WAUDV74F68N041416", "used", 14000);
	newUsedCar.push_back(n);
	o.setCar("Chevy", "Mallibu", 10000.00, "1N4BL11D96N426956", "used", 52000);
	newUsedCar.push_back(o);
	p.setCar("GMC", "Sierra", 24000.00, "1GTG6CE36F1133527", "used", 48000);
	newUsedCar.push_back(p);
	q.setCar("GMC", "Yukon", 5500.00, "5FRYD3H66FB006086", "used", 290000);
	newUsedCar.push_back(q);
	r.setCar("GMC", "Sierra", 2800.00, "1GCHK29G73E153846", "used", 276000);
	newUsedCar.push_back(r);
	s.setCar("GMC", "Canyon", 14600.00, "1N6BA0ED5CN300770", "used", 198000);
	newUsedCar.push_back(s);
	t.setCar("GMC", "Terrain", 22000.00, "1GNES16S166154485", "used", 168000);
	newUsedCar.push_back(t);
}
//search car function
void searchInventory(vector<newCar>& newNewCar, vector<usedCar>&newUsedCar)
{
	int input1, input2, input3, input4;
	string model;

	cout << "Search Inventory by:\n\n1. New Cars\n"
		"2. Used Cars\n3. Price Range\n\nEnter Choice: ";
	cin >> input1;

	if (input1 == 1) { //search new cars
		system("cls");
		cout << "1. Make\n2. Model\n\nEnter Choice: ";
		cin >> input2;
		if (input2 == 1) { //search new car make
			system("cls");
			cout << "1. Cheyv\n2. GMC\n\nEnter Choice: ";
			cin >> input3;
			if (input3 == 1) { //new make chevy
				system("cls");
				for (int i = 0; i < newNewCar.size(); i++) {
					if (newNewCar[i].getMake() == "Chevy") {
						newNewCar[i].print();
					}
				}
			}//end of print new chevy cars
			else if (input3 == 2) { //new make gmc
				system("cls");
				for (int i = 0; i < newNewCar.size(); i++) {
					if (newNewCar[i].getMake() == "GMC") {
						newNewCar[i].print();
					}
				}
			}//end of print new gmc cars
		}//end of search new car make
		else if (input2 == 2) { //search new car model
			system("cls");
			cout << "Enter Model: ";
			cin >> model;
			system("cls");
			for (int j = 0; j < newNewCar.size(); j++) {
				if (newNewCar[j].getModel() == model) {
					newNewCar[j].print();
				}
			}//end of print new model
		}//end of new model search
	}//end of new car search

	else if (input1 == 2) { //search used cars
		system("cls");
		cout << "1. Make\n2. Model\n\nEnter Choice: ";
		cin >> input2;
		if (input2 == 1) { //search used car make
			system("cls");
			cout << "1. Cheyv\n2. GMC\n\nEnter Choice: ";
			cin >> input3;
			if (input3 == 1) { //print used car make chevy
				system("cls");
				for (int i = 0; i < newUsedCar.size(); i++) {
					if (newUsedCar[i].getMake() == "Chevy") {
						newUsedCar[i].print();
					}
				}
			}//end of print used chevy cars
			else if (input3 == 2) { //print used car make gmc
				system("cls");
				for (int i = 0; i < newUsedCar.size(); i++) {
					if (newUsedCar[i].getMake() == "GMC") {
						newUsedCar[i].print();
					}
				}
			}//end of print used gmc cars
		}//end of search make
		else if (input2 == 2) { //search used car model
			system("cls");
			cout << "Enter Model: ";
			cin >> model;
			system("cls");
			for (int j = 0; j < newUsedCar.size(); j++) {
				if (newUsedCar[j].getModel() == model) {
					newUsedCar[j].print();
				}
			}//end of print new model
		}//end of new model search
	}// end of used car search

	if (input1 == 3) {
		system("cls");
		float minPrice = 0.00, maxPrice = 0.00;
		cout << "Minimum price: ";
		cin >> minPrice;
		cout << "Max price: ";
		cin >> maxPrice;
		system("cls");

		cout << "*****New Cars in Price Range*****\n\n";
		///////////PRINT NEW CARS IN USER PRICE RANGE/////////////
		for (int k = 0; k < newNewCar.size(); k++) {
			if (newNewCar[k].getPrice() >= minPrice && newNewCar[k].getPrice() <= maxPrice) {
				newNewCar[k].print();
			}
		}
		////////PRINT USED CARS IN USER PRICE RANGE/////////////
		cout << "*****Used Cars in Price Range*****\n\n";
		for (int l = 0; l < newNewCar.size(); l++) {
			if (newUsedCar[l].getPrice() > minPrice && newUsedCar[l].getPrice() < maxPrice) {
				newUsedCar[l].print();
			}
		}
	}

	system("pause");
	system("cls");
}
//sell or lease car function
void sell_lease(vector<newCar>& newNewCar, vector<usedCar>& newUsedCar)
{
	int input1, input2;
	string VIN;
	bool found1 = false, found2 = false, found3 = false;

	cout << "Selling or Leasing a Car?\n\n1. Sell\n2. Lease\n\n"
		"Enter Choice: ";
	cin >> input1;
	system("cls");
	if (input1 == 1) {
		cout << "1. New\n2. Used\n\nEnter Choice: ";
		cin >> input2;
		system("cls");

			///////OPTION 1: SELL////////
			if (input2 == 1) {
				cout << "Enter VIN of new car : ";
				cin >> VIN;

				for (vector<newCar>::iterator it1 = newNewCar.begin(); it1 != newNewCar.end(); ++it1) {
					if (VIN == it1->getVin()) {
						newNewCar.erase(it1);
						found1 = true;
						cout << "VIN number " << VIN << " removed from inventory.\n";
						break;
					}
				}
				if (found1 = false) {
					system("cls");
					cout << "Car was not found." << endl;
			}
			}
			else if (input2 == 2) {
				cout << "Enter VIN of used car: ";
				cin >> VIN;

				for (vector<usedCar>::iterator it2 = newUsedCar.begin(); it2 != newUsedCar.end(); ++it2) {
					if (VIN == it2->getVin()) {
						newUsedCar.erase(it2);
						found2 = true;
						cout << "VIN number " << VIN << " removed from inventory.\n";
						break;
					}
				}
				if (found2 = false) {
					system("cls");
					cout << "Car was not found." << endl;
				}
			}
		}
	///////OPTION 2: LEASE///////////
	else if (input1 == 2) {
		cout << "Enter VIN of car to lease: ";
		cin >> VIN;
		for (vector<newCar>::iterator it1 = newNewCar.begin(); it1 != newNewCar.end(); ++it1) {
			if (VIN == it1->getVin()) {
				newNewCar.erase(it1);
				found3 = true;
				cout << "VIN number " << VIN << " removed from inventory.\n";
				break;
			}
		}
		if (found3 = false) {
			system("cls");
			cout << "Car not found." << endl;
		}
	}
	system("pause");
	system("cls");
}
//return a leased car function
void returnLease(vector<newCar>& newNewCar, vector<usedCar>& newUsedCar)
{
	cout << "Enter used car information:\n\n";

	string make, model, vin;
	float price;
	int mileage;
	cout << "Make: ";
	cin >> make;
	cout << "Model: ";
	cin >> model;
	cout << "Price: ";
	cin >> price;
	cout << "VIN: ";
	cin >> vin;
	cout << "Mileage: ";
	cin >> mileage;

	try {
		for (vector<newCar>::iterator it1 = newNewCar.begin(); it1 != newNewCar.end(); ++it1) {
			if (vin == it1->getVin()) {
				throw 99;
			}
		}
		usedCar b;
		b.setCar(make, model, price, vin, "used", mileage);
		newUsedCar.push_back(b);
		cout << "Car added to used inventory." << endl;
		system("pause");
		system("cls");
	}

	catch (int x) {
		system("cls");
		cout << "\n*************ERROR!*************\n\nThe VIN " 
			"for that car is already in the iventory.\n" << endl;
		system("pause");
		system("cls");
	}
}
//add a car function
void addCar(vector<newCar>& newNewCar, vector<usedCar>&newUsedCar)
{
	cout << "Entering a new or used car?\n\n1. New\n2. Used\n\nEnter Choice: ";
	int input;
	string cat;
	cin >> input;
	system("cls");
	string make, model, vin, warranty;
	float price;
	int mileage;
	cout << "Make: ";
	cin >> make;
	cout << "Model: ";
	cin >> model;
	cout << "Price: ";
	cin >> price;
	cout << "VIN: ";
	cin >> vin;
	if (input == 1) { 
		cat = "new";
		newCar a;
		cout << "Warranty Provider: ";
		cin.ignore();
		getline(cin, warranty);
		a.setCar(make, model, price, vin, cat, warranty);
		newNewCar.push_back(a);
	}
	else if (input == 2) {
		cat = "used";
		usedCar b;
		cout << "Mileage: ";
		cin >> mileage;
		b.setCar(make, model, price, vin, cat, mileage);
		newUsedCar.push_back(b);
	}
	system("pause");
	system("cls");
}
//get inventory function
void getInventory(vector<newCar>& newNewCar, vector<usedCar>& newUsedCar)
{
	cout << "Show Invetory by Category:\n\n1. New\n2. Used\n3. All \n\nEnter Choice: ";
	int input;
	cin >> input;
	system("cls");

	if (input == 1) {
		cout << "**************New Cars************** " << endl;
		cout << endl;
		for (int i = 0; i < newNewCar.size(); i++) {
			newNewCar[i].print();
		}
		system("pause");
		system("cls");
	}

	else if (input == 2) {
		cout << "**************Used Cars**************" << endl;
		cout << endl;
		for (int i = 0; i < newUsedCar.size(); i++) {
			newUsedCar[i].print();
		}
		system("pause");
		system("cls");
	}

	else if (input == 3) {
		cout << "**************New Cars**************" << endl;
		cout << endl;
		for (int i = 0; i < newNewCar.size(); i++) {
			newNewCar[i].print();
		}

		cout << endl;
		cout << "**************Used Cars**************" << endl;
		for (int i = 0; i < newUsedCar.size(); i++) {
		newUsedCar[i].print();
		cout << endl;
		}
		system("pause");
		system("cls");
	}
}
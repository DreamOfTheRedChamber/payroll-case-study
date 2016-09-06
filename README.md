# Payroll Case Study
==================

This is my learning journey of the Payroll Case Study from the book "Agile Software
Development principles patterns and practices" by Robert C. Martin (a.k.a. Uncle Bob).

It is written in Java, using JUnit and Hamcrest for testing, Maven for dependency management.

# Overview
  * [Use Cases](#use-case)
  * [Core Class UMLs](#core-class-UMLs)
  * [Core Sequence UMLs](#core-sequence-UMLs)
  * [Adopted Design Patterns](#design-patterns)
  * [Package Design](#package-design)
  * [References](#reference)

## Use Cases <a id="use-case"></a>
![Use case diagram](/images/Payroll-use-case.png)

## Core Class UMLs <a id="core-class-UMLs"></a>
#### Employee
![Employee](/images/class-Employee.png)

#### AddEmployeeTransaction
![AddEmployee](/images/class-AddEmployeeTransaction.png)

#### ChangeEmployeeTransaction
![ChangeEmployeeTransaction1](/images/class-ChangeEmployeeTransaction.png)

#### DeleteEmployeeTransaction
![DeleteEmployee](/images/class-DeleteEmployeeTransaction-1.png)

#### TimeCardTransaction
![TimeCardTransaction](/images/class-TimeCardTransaction.png)

#### SalesReceiptTransaction
![SalesReceiptTransaction](/images/class-SalesReceiptTransaction.png)

#### ServiceChargeTransaction
![ServiceChargeTransaction](/images/class-ServiceChargeTransaction.png)

#### PaydayTransaction
![PaydayTransaction](/images/class-paydaytransaction.png)

## Core Sequence UMLs <a id="core-sequence-UMLs"></a>
#### Main program
![MainProgram](/images/seq-MainProgram.png)

#### PaydayTransaction
![PaydayTransaction](/images/seq-PaydayTransaction.png)

#### ChangeClassificationTransaction
![ChangeMethodTransaction](/images/seq-ChangeClassificationTransaction.png)

#### ChangeMethodTransaction
![](/images/seq-ChangeMethodTransaction.png)

#### ChangeAffiliationTransaction
![](/images/seq-ChangeAffiliationTransaction.png)

#### ServiceChargeTransaction
![](/images/seq-ServiceChargeTransaction.png)

#### SalesReceiptTransaction
![](/images/seq-SalesReceiptTransaction.png)

#### TimeCardTransaction
![](/images/seq-TimeCardTransaction.png)

#### AddEmployeeTransaction
![](/images/seq-AddEmployees.png)


## Adopted Design Patterns <a id="design-patterns"></a>
![](/images/designPatterns.png)

## Package Design <a id="package-design"></a>
#### Entities
![](/images/payroll-implemented-entities.png)
#### Transactions
![](/images/payroll-implemented-trans-structure.png)

## Reference<a id="reference"></a>
---------
[https://github.com/Ookami86/payroll-casestudy](https://github.com/Ookami86/payroll-casestudy "Johannes Seitz's implementation")

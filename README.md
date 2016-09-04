# Payroll Case Study
==================

This is my learning journey of the Payroll Case Study from the book Agile Software
Development by Robert C. Martin (a.k.a. Uncle Bob).

# Overview
  * [Use Cases](#use-case)
  * [Core Class UMLs](#core-class-UMLs)
  * [Core Sequence UMLS](#core-sequence-UMLs)
  * [Adopted Design Patterns](#design-patterns)
  * [Package Design](#package-design)

## Use Cases <a id="use-case"></a>
![Use case diagram](/images/Payroll-use-case.png)

## Core Class UMLs <a id="core-class-UMLs"></a>
* Employee
![Employee](/content/images/2016/08/class-Employee.png)

* AddEmployeeTransaction
![AddEmployee](/content/images/2016/08/class-AddEmployeeTransaction.png)

* ChangeEmployeeTransaction
![ChangeEmployeeTransaction1](/content/images/2016/08/class-ChangeEmployeeTransaction.png)

* DeleteEmployeeTransaction
<div style="width: 500px">
![DeleteEmployee](/content/images/2016/08/class-DeleteEmployeeTransaction-1.png)
</div>

* TimeCardTransaction
<div style="width: 500px">
![TimeCardTransaction](/content/images/2016/08/class-TimeCardTransaction.png)
</div>

* SalesReceiptTransaction
![SalesReceiptTransaction](/content/images/2016/08/class-SalesReceiptTransaction.png)
* ServiceChargeTransaction
![ServiceChargeTransaction](/content/images/2016/08/class-ServiceChargeTransaction.png)

* PaydayTransaction
<div style="width: 500px">
![](/content/images/2016/08/class-paydaytransaction.png)
</div>

## Core Sequence UMLs <a id="core-sequence-UMLs"></a>
* Main program
![](/content/images/2016/08/seq-MainProgram.png)
* PaydayTransaction
![](/content/images/2016/08/seq-PaydayTransaction.png)
* ChangeClassificationTransaction
![](/content/images/2016/08/seq-ChangeClassificationTransaction.png)
* ChangeMethodTransaction
![](/content/images/2016/08/seq-ChangeMethodTransaction.png)
* ChangeAffiliationTransaction
![](/content/images/2016/08/seq-ChangeAffiliationTransaction.png)
* ServiceChargeTransaction
![](/content/images/2016/08/seq-ServiceChargeTransaction.png)
* SalesReceiptTransaction
![](/content/images/2016/08/seq-SalesReceiptTransaction.png)
* TimeCardTransaction
![](/content/images/2016/08/seq-TimeCardTransaction.png)
* AddEmployeeTransaction
![](/content/images/2016/08/seq-AddEmployees.png)


## Adopted Design Patterns <a id="design-patterns"></a>
![](/content/images/2016/08/designPatterns.png)

## Package Design <a id="package-design"></a>
* Implemented package structure
  * Entities
![](/content/images/2016/08/payroll-implemented-entities.png)
  * Transactions
![](/content/images/2016/08/payroll-implemented-trans-structure.png)

Reference
---------
[https://github.com/Ookami86/payroll-casestudy](https://github.com/Ookami86/payroll-casestudy "Johannes Seitz's implementation")

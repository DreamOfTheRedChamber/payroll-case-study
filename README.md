# Payroll Case Study
==================

This is my learning journey of the Payroll Case Study from the book <<Agile Software
Development>> by Robert C. Martin (a.k.a. Uncle Bob).

# Overview
  * [Use Cases](#use-case)
  * [Core Class UMLs](#core-class-UMLs)
  * [Core Sequence UMLS](#core-sequence-UMLs)
  * [Adopted Design Patterns](#design-patterns)
  * [Package Design](#package-design)
  * [Reference](#reference)
## Use Cases <a id="use-case"></a>
![Use case diagram](/images/Payroll-use-case.png)

## Core Class UMLs <a id="core-class-UMLs"></a>
* Employee
![Employee](/images/class-Employee.png)

* AddEmployeeTransaction
![AddEmployee](/images/class-AddEmployeeTransaction.png)

* ChangeEmployeeTransaction
![ChangeEmployeeTransaction1](/images/class-ChangeEmployeeTransaction.png)

* DeleteEmployeeTransaction
<div style="width: 500px">
![DeleteEmployee](/images/class-DeleteEmployeeTransaction-1.png)
</div>

* TimeCardTransaction
<div style="width: 500px">
![TimeCardTransaction](/images/class-TimeCardTransaction.png)
</div>

* SalesReceiptTransaction
![SalesReceiptTransaction](/images/class-SalesReceiptTransaction.png)
* ServiceChargeTransaction
![ServiceChargeTransaction](/images/class-ServiceChargeTransaction.png)

* PaydayTransaction
<div style="width: 500px">
![](/images/class-paydaytransaction.png)
</div>

## Core Sequence UMLs <a id="core-sequence-UMLs"></a>
* Main program
![](/images/seq-MainProgram.png)
* PaydayTransaction
![](/images/seq-PaydayTransaction.png)
* ChangeClassificationTransaction
![](/images/seq-ChangeClassificationTransaction.png)
* ChangeMethodTransaction
![](/images/seq-ChangeMethodTransaction.png)
* ChangeAffiliationTransaction
![](/images/seq-ChangeAffiliationTransaction.png)
* ServiceChargeTransaction
![](/images/seq-ServiceChargeTransaction.png)
* SalesReceiptTransaction
![](/images/seq-SalesReceiptTransaction.png)
* TimeCardTransaction
![](/images/seq-TimeCardTransaction.png)
* AddEmployeeTransaction
![](/images/seq-AddEmployees.png)


## Adopted Design Patterns <a id="design-patterns"></a>
![](/images/designPatterns.png)

## Package Design <a id="package-design"></a>
* Implemented package structure
  * Entities
![](/images/payroll-implemented-entities.png)
  * Transactions
![](/images/payroll-implemented-trans-structure.png)

## Reference<a id="reference"></a>
---------
[https://github.com/Ookami86/payroll-casestudy](https://github.com/Ookami86/payroll-casestudy "Johannes Seitz's implementation")

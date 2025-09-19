# TBC Second Project

## Overview
This project is an automated testing framework for TBC Digital with the following features:

- **Multi-browser execution**: Chrome, Firefox, WebKit  
- **SQL database parametrization**: Test data fetched dynamically from `location_cases` table  
- **Data-driven tests**: TestNG `DataProvider` usage  
- **Visual regression testing**: Screenshot comparison for one scenario  
- **Mobile emulation**: iPhone viewport tests  
- **Parallel execution**: Run tests simultaneously on multiple browsers  

## Tech Stack
- **Java**: Core programming language  
- **Playwright**: Browser automation (Chrome, Firefox, WebKit)  
- **TestNG**: Test execution framework with parallel support  
- **JDBC**: Database connection for test data  
- **Maven**: Build and dependency management  
- **BackstopJS / Playwright Screenshot**: Visual regression testing  

## Prerequisites
Before running the project, make sure you have:

- **Java 17+** installed  
- **Maven 3.8+** installed  
- **Internet connection** (for browser download)  
- **MSSQL Database running** (for Locations test)  


# IP Information Checker - README

## Description
Welcome to the **IP Information Checker** project! This Java project provides classes to determine if an IP address falls within a specified IP range. It reads IP ranges from a CSV file, checks if a given IP address belongs to any range, and returns relevant information.

## Classes and Functionality
The project consists of three Java classes:

1. **ipCheck**: Retrieves the client's IP address using Spring Framework's `RequestContextHolder`. Handles different headers to extract the correct IP address, and substitutes `127.0.0.1` for `0:0:0:0:0:0:0:1` for local requests.

2. **ipDbReader**: Reads IP ranges from a CSV file. Parses each line to create a list of IP range values. Provides a list of IP ranges for the `ipInformationCheck` class.

3. **ipInformationCheck**: Compares a client's IP address against the list of IP ranges. Determines if the IP address falls within any range and returns relevant information.

## Usage
1. Create a CSV file containing IP ranges, with each line representing a range as `startIP,endIP` format.
2. Instantiate the `ipCheck` class to get the client's IP address.
3. Instantiate the `ipDbReader` class and use the `readerDB` method to populate the IP range list from the CSV file.
4. Instantiate the `ipInformationCheck` class, passing the client's IP address and IP range list.
5. Call the `check` method to determine if the client's IP address is within any range.

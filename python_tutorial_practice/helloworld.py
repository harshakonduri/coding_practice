#!/usr/bin/python

#import modules
import sys

def main():
    print 'Hello World'
# the argv is a module in sys to 
# print the arguements out as a list
    print sys.argv

def func():
    print 'hi'

if __name__ == '__main__':
    func()
    main()

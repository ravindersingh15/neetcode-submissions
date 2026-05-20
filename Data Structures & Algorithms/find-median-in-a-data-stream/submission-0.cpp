class MedianFinder {
public:
    // Using Heap
    // Dividing all values in 2 heaps
    // one minheap and one maxheap
    // combining the result for median
    // designing in such way that left queue contains higher or equal number of elements
    priority_queue<int> left;
    priority_queue<int, vector<int>, greater<int>> right;
    MedianFinder() {
        left = priority_queue<int>();
        right = priority_queue<int, vector<int>, greater<int>>();
    }
    
    void addNum(int num) {
        // inserting a number
        right.push(num);
        while(left.size() < right.size()) {
            left.push(right.top());
            right.pop();
        }
        // rebalancing the heap
        if(right.size() > 0) {
            while(left.top() > right.top()) {
                int temp = left.top();
                left.pop();
                left.push(right.top());
                right.pop();
                right.push(temp);
            }
        }
    }
    
    double findMedian() {
        if((left.size() + right.size()) % 2 != 0) {
            return left.top();
        }
        return (left.top() + right.top()) / 2.0;
    }
};

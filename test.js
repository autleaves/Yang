function findCombinations(target, start, path, results) {
    // If the current path sums up to the target, add it to results
    if (target === 0) {
        results.push([...path]);
        return;
    }
    // If the current sum exceeds the target, return
    if (target < 0) {
        return;
    }

    // Iterate through numbers starting from 'start' to avoid duplicates
    for (let i = start; i <= 20; i++) {
        path.push(i); // Include the current number
        findCombinations(target - i, i + 1, path, results); // Recur with the reduced target and the next number
        path.pop(); // Backtrack to explore other combinations
    }
}

function getAllCombinations(target) {
    const results = [];
    findCombinations(target, 1, [], results); // Start from 1
    return results;
}

const target = 20;
const combinations = getAllCombinations(target);
console.log(JSON.stringify(combinations, null, 2));

package py.com.daas.java.testdome;


public class CacheCasting {

    public static class Cache {}
    public static class DiskCache extends Cache {}
    public static class MemoryCache extends Cache {}
    public static class OptimizedDiskCache extends DiskCache {}

    public static void main(String[] args) {
        OptimizedDiskCache optimizedDiskCache = new OptimizedDiskCache();
        Cache cache = (Cache) optimizedDiskCache;


        /*MemoryCache memoryCache = new MemoryCache();
        cache = (Cache) memoryCache;
        DiskCache diskCache = (DiskCache) cache;*/


        /*DiskCache diskCache = new DiskCache();
        optimizedDiskCache = (OptimizedDiskCache) diskCache;*/


        optimizedDiskCache = new OptimizedDiskCache();
        DiskCache diskCache = (DiskCache) optimizedDiskCache;


        /*cache = new Cache();
        MemoryCache memoryCache = (MemoryCache) cache;*/


        optimizedDiskCache = new OptimizedDiskCache();
        cache = (Cache) optimizedDiskCache;
        diskCache = (DiskCache) cache;
    }

}

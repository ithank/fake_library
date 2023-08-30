import com.ops.mapMerge

def call(maps){
    def mm =  new mapMerge(maps)
    return mm.merge(maps)
}
